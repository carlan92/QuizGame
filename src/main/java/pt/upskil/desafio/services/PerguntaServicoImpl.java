package pt.upskil.desafio.services;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import pt.upskil.desafio.entities.Dificuldade;
import pt.upskil.desafio.entities.Pergunta;
import pt.upskil.desafio.entities.Resposta;
import pt.upskil.desafio.exceptions.AdicionarPerguntaException;
import pt.upskil.desafio.exceptions.InvalidPerguntaException;
import pt.upskil.desafio.exceptions.ObterEstatisticaException;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.apiUtils.EstatisticaResponse;
import pt.upskil.desafio.services.apiUtils.ListaPerguntasResponse;
import pt.upskil.desafio.services.apiUtils.PerguntaResponse;
import pt.upskil.desafio.services.apiUtils.StatusResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerguntaServicoImpl implements PerguntaServico {

    public static void main(String[] args) {
        PerguntaServico perguntaServico = new PerguntaServicoImpl();
        Pergunta p = new Pergunta();
        ArrayList<Resposta> respostas = new ArrayList<>(4);
        respostas.add(new Resposta(p, "wrong answer", false));
        respostas.add(new Resposta(p, "wrong answer", false));
        respostas.add(new Resposta(p, "right answer", true));
        respostas.add(new Resposta(p, "wrong answer", false));
        p.setRespostas(respostas);
        p.setDificuldade(Dificuldade.FACIL);
        p.setDescricao("Qual é a certa? (Teste pergunta feito pelo grupo 2)");
        try {
            perguntaServico.addicionarPergunta(p);
        } catch (AdicionarPerguntaException e) {
            e.printStackTrace();
        }
        //try {
        //    for (Pergunta p : perguntaServico.obterPerguntas(Dificuldade.FACIL)) {
        //        System.out.println(p.getDescricao());
        //        for (Resposta r : p.getRespostas())
        //            System.out.println(r.getTexto());
        //    }
        //} catch (ObterPerguntasException e) {
        //    e.printStackTrace();
        //}
    }

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    static {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }
    private static final String URL_ADDICIONAR_PERGUNTA = "https://serro.pt/perguntas/nova";
    private static final String URL_PEDIR_PERGUNTAS = "https://serro.pt/perguntas/%s"; //%s place-holder para difficuldade
    private static final String URL_PEDIR_ESTATISTICAS= "https://serro.pt/perguntas";

    @Override
    public void addicionarPergunta(Pergunta pergunta) throws AdicionarPerguntaException {
        JSONObject perguntaRequest = new JSONObject();
        perguntaRequest.put("pergunta", pergunta.getDescricao());
        List<Resposta> respostas = pergunta.getRespostas();
        if (respostas.size() != Pergunta.NUM_RESPOSTAS) {
            throw new InvalidPerguntaException("A pergunta não tem o numero de respostas certo");
        }
        int certa = -1;
        for (int i = 1; i < respostas.size() + 1; i++) {
            Resposta resposta = respostas.get(i - 1);
            if (resposta.isCerta())
                certa = i;
            perguntaRequest.put("resposta" + i, resposta);
        }
        if (certa == -1) {
            throw new InvalidPerguntaException("A pergunta não tem nenhuma resposta indicada como certa");
        }
        perguntaRequest.put("certa", Integer.toString(certa));
        perguntaRequest.put("dificuldade", pergunta.getDificuldade().getApiText());

        StatusResponse response = null;
        try {
            response = restTemplate.postForObject(URL_ADDICIONAR_PERGUNTA,
                new HttpEntity<>(perguntaRequest.toString(), headers), StatusResponse.class);
        } catch (HttpClientErrorException |
                HttpServerErrorException |
                UnknownHttpStatusCodeException e) {
        }
        if(response == null || response.status.equals("error")) {
            throw new AdicionarPerguntaException();
        }
    }

    @Override
    public List<Pergunta> obterPerguntas(Dificuldade dificuldade) throws ObterPerguntasException {
        ListaPerguntasResponse response;
        try {
            response = restTemplate.getForObject(String.format(URL_PEDIR_PERGUNTAS, dificuldade.getApiText()), ListaPerguntasResponse.class);
        } catch (HttpClientErrorException |
                HttpServerErrorException |
                UnknownHttpStatusCodeException e) {
            throw new ObterPerguntasException();
        }
        if (response == null || response.getStatus().equals("error")) {
            throw new ObterPerguntasException();
        }

        List<Pergunta> perguntas = new ArrayList<>(response.getPerguntas().size());
        for (PerguntaResponse pr : response.getPerguntas()) {
            Pergunta pergunta = new Pergunta();
            pergunta.setDescricao(pr.getDescricao());
            List<Resposta> respostas = new ArrayList<>(Pergunta.NUM_RESPOSTAS);
            respostas.add(new Resposta(pergunta, pr.getResposta1(), pr.getCerta().equals("1")));
            respostas.add(new Resposta(pergunta, pr.getResposta2(), pr.getCerta().equals("2")));
            respostas.add(new Resposta(pergunta, pr.getResposta3(), pr.getCerta().equals("3")));
            respostas.add(new Resposta(pergunta, pr.getResposta4(), pr.getCerta().equals("4")));
            pergunta.setRespostas(respostas);
            pergunta.setDificuldade(Dificuldade.getDifficuldadeFromApiText(pr.getDificuldade()));
            perguntas.add(pergunta);
        }

        //TODO salvar perguntas e respostas na base dados ?

        return perguntas;
    }

    @Override
    public Map<String, Integer> obterEstatisticas() throws ObterEstatisticaException {
        EstatisticaResponse response;
        try {
            response = restTemplate.getForObject(URL_PEDIR_ESTATISTICAS, EstatisticaResponse.class);
        } catch (HttpClientErrorException |
                HttpServerErrorException |
                UnknownHttpStatusCodeException e) {
            throw new ObterEstatisticaException();
        }
        if (response == null || response.getStatus().equals("error")) {
            throw new ObterEstatisticaException();
        }
        Map<String, Integer> result = new HashMap<>();
        result.put("total", Integer.valueOf(response.getTotal()));
        result.put("fáceis", Integer.valueOf(response.getFaceis()));
        result.put("médias", Integer.valueOf(response.getMedias()));
        result.put("difíceis", Integer.valueOf(response.getDificeis()));
        result.put("impossíveis", Integer.valueOf(response.getImpossiveis()));
        return result;
    }

    @Override
    public int obterNumeroTotalDePerguntas() throws ObterEstatisticaException {
        return obterEstatisticas().get("total");
    }
}
