package pt.upskil.desafio.services;

import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.ObterPerguntasException;

import java.util.List;

public interface JogoService {
    int highScore(User user);
    int highScorePosition(User user);
    List<Jogo> findAll();
    void iniciarJogo(User user) throws ObterPerguntasException;
    void fecharJogos(User user);
    void save(Jogo jogo);
    List<Integer> usarAjudaPublico(User currentUser);
}
