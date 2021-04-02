package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.*;
import pt.upskil.desafio.exceptions.AjudaAlreadyUsedException;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.RondaService;
import pt.upskil.desafio.services.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.SECONDS;

@RestController
public class JogoRestController {
    @Autowired
    UserService userService;
    @Autowired
    JogoService jogoService;
    @Autowired
    RondaService rondaService;


    @GetMapping("/player/game/ajudaPublico")
    public List<Double> ajudaPublico() {
        User user = userService.currentUser();
        try {
            return jogoService.usarAjudaPublico(user);
        } catch (NoGameActiveException e) {
            e.printStackTrace();
            return null;
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
            return null;
        }
    }

    @GetMapping("/player/game/ajuda5050")
    public List<Integer> ajuda5050() {
        User user = userService.currentUser();
        try {
            return jogoService.usar5050(user);
        } catch (NoGameActiveException e) {
            e.printStackTrace();
            return null;
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
            return null;
        }
    }

    @GetMapping("/player/game/ajudaTrocaPergunta")
    public List<String> ajudaTrocaPergunta() {
        User user = userService.currentUser();
        try {
            Pergunta novaPergunta = jogoService.usarTrocaPergunta(user);
            List<String> perguntaParts = new ArrayList<>();
            perguntaParts.add(novaPergunta.getDescricao());
            for (int i = 0; i < Pergunta.NUM_RESPOSTAS; i++) {
                perguntaParts.add(novaPergunta.getRespostas().get(i).getTexto());
            }
            return perguntaParts;
        } catch (NoGameActiveException e) {
            e.printStackTrace();
            return null;
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
            return null;
        } catch (ObterPerguntasException e) {
            e.printStackTrace();
            return null;
        }
    }


    @GetMapping("/player/game/terminar")
    public void terminarJogo() {
        jogoService.fecharJogos(userService.currentUser());
    }

    @GetMapping("/player/game/verificar-resposta/{nrResposta}")
    public Map<String, String> verificarResposta(@PathVariable int nrResposta) throws NoGameActiveException  {//TODO
        LocalDateTime horaResposta = LocalDateTime.now();
        Map<String, String> resultado = new HashMap<>();

        Jogo jogo = userService.currentUser().getJogoCorrente();

        // Verificar se resposta é correcta
        if (jogoService.responderPergunta(userService.currentUser(), nrResposta, horaResposta)) {
            resultado.put("respostaCorrecta", "true");

            if (nrResposta == jogo.getRondas().size()) {
                // Se for a última pergunta termina o jogo
                jogo.setFinished(true);
                resultado.put("terminou", "true");
            } else {
                // Se resposta correcta enviar dados da nova pergunta
                Ronda novaRonda = jogo.proximaRonda();
                Pergunta novaPergunta = novaRonda.getPergunta();
                jogo.setRondaAtual(novaRonda);

                novaRonda.setStartTime(LocalDateTime.now());
                rondaService.save(novaRonda);

                resultado.put("pergunta", novaPergunta.getDescricao());
                resultado.put("resposta1", novaPergunta.getRespostas().get(0).getTexto());
                resultado.put("resposta2", novaPergunta.getRespostas().get(1).getTexto());
                resultado.put("resposta3", novaPergunta.getRespostas().get(2).getTexto());
                resultado.put("resposta4", novaPergunta.getRespostas().get(3).getTexto());
                resultado.put("rondaNr", Integer.toString(novaRonda.getNumero()));
                resultado.put("pontos", Integer.toString(jogo.getGameScore()));
                resultado.put("rondaTempo", Long.toString(novaPergunta.getDificuldade().getDuration().get(SECONDS)));
                resultado.put("terminou", "false");
            }

            jogoService.save(jogo);

        } else {
            resultado.put("respostaCorrecta", "false");
            jogoService.fecharJogos(userService.currentUser());
        }
        return resultado;
    }

}
