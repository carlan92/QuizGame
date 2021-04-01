package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pt.upskil.desafio.entities.Ronda;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.UserService;
import pt.upskil.desafio.utils.AlertMessageImage;


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
            modelMap.put("message", "Não iniciar o jogo.");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "component/alert-message";
        }


        Ronda ronda = null;
        try {
            ronda = user.getJogoCorrente().getRondaAtual();
        } catch (NoGameActiveException e) {
            modelMap.put("message", "Não iniciar o jogo.");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "component/alert-message";
        }

        modelMap.put("ronda", ronda);
        return "player/game";
    }

}
