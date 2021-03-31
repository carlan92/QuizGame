package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.Pergunta;
import pt.upskil.desafio.entities.Ronda;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.PerguntaServico;
import pt.upskil.desafio.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JogoController {
    @Autowired
    UserService userService;
    @Autowired
    PerguntaServico perguntaServico;

    public void jogo() {

        // iniciar jogo
        Jogo jogo = new Jogo();
        jogo.setUser(userService.currentUser());


        // criar obter perguntas
        List<Pergunta> perguntas;
        try {
            perguntas = perguntaServico.obter15Perguntas();
        } catch (ObterPerguntasException e) {
            e.printStackTrace();
            // TODO erros
            return;
        }

        // criar rondas
        List<Ronda> rondas = new ArrayList<>();

        int nrPergunta = 1;
        for (Pergunta pergunta : perguntas) {
            Ronda ronda = new Ronda(nrPergunta, pergunta, jogo);
            // TODO save ronda
            rondas.add(ronda);
            nrPergunta += 1;
        }

        jogo.setRondas(rondas);
        jogo.setRondaAtual(rondas.get(0));

        // TODO save Game

    }
}
