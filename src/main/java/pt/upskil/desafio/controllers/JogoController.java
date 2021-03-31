package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.Ronda;
import pt.upskil.desafio.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JogoController {
    @Autowired
    UserService userService;

    public void jogo(){

        // iniciar jogo
        Jogo jogo = new Jogo();
        jogo.setUser(userService.currentUser());


        // criar rondas
        List<Ronda> rondas = new ArrayList<>();
        jogo.setRondas(null);
        jogo.setRondaAtual(rondas.get(0));



    }
}
