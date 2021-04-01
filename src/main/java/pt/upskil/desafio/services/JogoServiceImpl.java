package pt.upskil.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.upskil.desafio.entities.*;
import pt.upskil.desafio.exceptions.AjudaAlreadyUsedException;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.repositories.JogoRepository;
import pt.upskil.desafio.repositories.RondaRepository;
import pt.upskil.desafio.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class JogoServiceImpl implements JogoService {
    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    PerguntaServico perguntaServico;
    @Autowired
    RondaRepository rondaRepository;


    @Override
    public int highScore(User user) {
        List<Jogo> jogos = jogoRepository.findAllByUserOrderByGameScoreDesc(user);
        if (jogos == null || jogos.isEmpty()) {
            return 0;
        }
        return jogos.get(0).getGameScore();
    }

    @Override
    public int highScorePosition(User user) {
        List<Jogo> jogos = jogoRepository.findAllByOrderByGameScoreDesc();

        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(0).getUser().equals(user)) {
                return i + 1;
            }
        }

        return jogos.size() + 1;
    }

    @Override
    public List<Jogo> findAll() {
        return jogoRepository.findAll();
    }

    @Override
    public void iniciarJogo(User user) throws ObterPerguntasException {
        // fechar jogos anteriores
        fecharJogos(user);

        // iniciar jogo
        Jogo jogo = new Jogo();
        jogo.setUser(userService.currentUser());
        user.getJogos().add(jogo);
        jogoRepository.save(jogo);

        // criar obter perguntas
        List<Pergunta> perguntas;

        perguntas = perguntaServico.obter15Perguntas();

        // criar rondas
        List<Ronda> rondas = new ArrayList<>();

        int nrPergunta = 1;
        for (Pergunta pergunta : perguntas) {
            Ronda ronda = new Ronda(nrPergunta, pergunta, jogo);
            rondas.add(ronda);
            nrPergunta += 1;

            // save Ronda
            rondaRepository.save(ronda);
        }

        jogo.setRondas(rondas);
        jogo.setRondaAtual(rondas.get(0));

        // save Game
        jogoRepository.save(jogo);

        // actualizar user
        userRepository.save(user);

    }

    @Override
    public void fecharJogos(User user) {
        List<Jogo> jogos = user.getJogos();
        for (Jogo jogo : jogos) {
            if (!jogo.isFinished()) {
                jogo.setFinished(true);
                jogoRepository.save(jogo);
            }
        }
    }

    @Override
    public void save(Jogo jogo) {
        jogoRepository.save(jogo);
    }

    @Override
    public List<Double> usarAjudaPublico(User user) throws NoGameActiveException, AjudaAlreadyUsedException {
        Jogo jogo = user.getJogoCorrente();
        if (jogo.isAjudaPublicoUsed()) {
            throw new AjudaAlreadyUsedException("A ajuda publico ja foi usada");
        }
        jogo.setAjudaPublicoUsed(true);
        save(jogo);
        //TODO
        return null;
    }

    /**
     * @return Lista de numeros das respostas que foram eliminadas pelo 5050.
     */
    @Override
    public List<Integer> usar5050(User user) throws NoGameActiveException, AjudaAlreadyUsedException {
        Jogo jogo = user.getJogoCorrente();
        if (jogo.isAjuda5050Used()) {
            throw new AjudaAlreadyUsedException("A ajuda 5050 ja foi usada");
        }
        jogo.setAjuda5050Used(true);
        save(jogo);
        List<Resposta> respostas = jogo.getRondaAtual().getPergunta().getRespostas();
        int respostaCerta = -1;
        for (int i = 0; i < Pergunta.NUM_RESPOSTAS; i++) {
            if (respostas.get(i).isCerta()) {
                respostaCerta = i + 1;
            }
        }
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int newRandomNumber = (int) (Math.random() * (Pergunta.NUM_RESPOSTAS - 1 - i)) + 1;
            for (int existingRandomNumber : randomNumbers) { //check that its not already in the list
                if (newRandomNumber >= existingRandomNumber) {
                    newRandomNumber = (newRandomNumber + 1);
                    if (newRandomNumber == Pergunta.NUM_RESPOSTAS) {
                        newRandomNumber = 1;
                    }
                }
            }
            randomNumbers.add(newRandomNumber);
            randomNumbers.sort((o1, o2) -> o1 - o2);
        }
        Integer numToMove = -1;
        for (int num : randomNumbers) {
            if (num == respostaCerta) {
                numToMove = num;
                break;
            }
        }
        if (numToMove != -1) {
            randomNumbers.remove(numToMove);
            randomNumbers.add(4);
        }
        return randomNumbers;
    }

    @Override
    public Pergunta usarTrocaPergunta(User user) throws NoGameActiveException, AjudaAlreadyUsedException {
        Jogo jogo = user.getJogoCorrente();
        if (jogo.isAjudaTrocaPerguntaUsed()) {
            throw new AjudaAlreadyUsedException("A ajuda 5050 ja foi usada");
        }
        jogo.setAjudaTrocaPerguntaUsed(true);
        save(jogo);
        //TODO
        return null;
    }
}

