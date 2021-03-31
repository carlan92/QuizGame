package pt.upskil.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.Pergunta;
import pt.upskil.desafio.entities.Ronda;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.repositories.JogoRepository;
import pt.upskil.desafio.repositories.RondaRepository;
import pt.upskil.desafio.repositories.UserRepository;

import java.util.ArrayList;
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

        // iniciar jogo
        Jogo jogo = new Jogo();
        jogo.setUser(userService.currentUser());
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

        user.setJogoCorrente(jogo);

        // save Game
        jogoRepository.save(jogo);

        // actualizar user
        userRepository.save(user);

    }
}
