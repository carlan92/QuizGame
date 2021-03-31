package pt.upskil.desafio.services;

import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;

import java.util.List;

public interface JogoService {
    int highScore(User user);
    int highScorePosition(User user);
    List<Jogo> findAll();

}
