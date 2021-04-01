package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.AjudaAlreadyUsedException;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.UserService;

import java.util.List;


@RestController
public class JogoRestController {
    @Autowired
    UserService userService;

    @Autowired
    JogoService jogoService;

    @GetMapping("/player/game/ajudaPublico")
    public void ajudaPublico() {
        User user = userService.currentUser();
        try {
            jogoService.usarAjudaPublico(user);
        } catch (NoGameActiveException e) {
            e.printStackTrace();
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
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
    public void ajudaTrocaPergunta() {
        User user = userService.currentUser();
        try {
            jogoService.usarTrocaPergunta(user);
        } catch (NoGameActiveException e) {
            e.printStackTrace();
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
        }
    }




    @GetMapping("/player/game/terminar")
    public void terminarJogo() {
        jogoService.fecharJogos(userService.currentUser());
    }


}
