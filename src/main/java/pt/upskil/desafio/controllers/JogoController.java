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

import java.time.Duration;


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
            modelMap.put("message", "Não foi possível buscar as perguntas para o jogo.");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "components/alert-message";
        }


        Ronda ronda = null;
        try {
            ronda = user.getJogoCorrente().getRondaAtual();
        } catch (NoGameActiveException e) {
            modelMap.put("message", "Não foi possível encontrar o jogo.");
            modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
            return "components/alert-message";
        }

        //obter duração do tempo de pergunta
        Duration duration= ronda.getPergunta().getDificuldade().getDuration();
        Long tempo= duration.getSeconds();

        modelMap.put("ronda", ronda);
        modelMap.put("tempo", tempo);
        return "player/game";
    }

    @GetMapping("/player/game/over")
    public String gameOver(ModelMap modelMap) {
        modelMap.put("message", "Game Over !!!");
        modelMap.put("imageURL", AlertMessageImage.FAILURE.getImageURL());
        return "components/alert-message";
    }

    @GetMapping("/player/game/victory")
    public String gameVictory(ModelMap modelMap) {
        modelMap.put("message", "Ganhou o Jogo !!! Parabéns !");
        modelMap.put("imageURL", AlertMessageImage.SUCCESS.getImageURL());
        return "components/alert-message";
    }

}
