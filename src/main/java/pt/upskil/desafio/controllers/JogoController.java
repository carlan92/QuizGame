package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.upskil.desafio.entities.Ronda;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.UserService;


@Controller
public class JogoController {
    @Autowired
    JogoService jogoService;
    @Autowired
    UserService userService;

    @GetMapping("/player/game")
    public String iniciarJogo(ModelMap modelMap) {
        User user = userService.currentUser();

        try {
            jogoService.iniciarJogo(user);
        } catch (ObterPerguntasException e) {
            e.printStackTrace();
            // TODO return e map para página de erro
        }


        Ronda ronda = user.getJogoCorrente().getRondaAtual();
        System.out.println(ronda.getPergunta().getRespostas());

        modelMap.put("ronda", ronda);
        return "player/game";
    }

}
