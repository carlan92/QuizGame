package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.UserService;


@RestController
public class JogoRestController {
    @Autowired
    UserService userService;

    @Autowired
    JogoService jogoService;

    @GetMapping("/player/game/ajudaPublico")
    public void ajudaPublico() {
        User user = userService.currentUser();
        jogoService.usarAjudaPublico(user);


    }

    @GetMapping("/player/game/ajuda5050")
    public void ajuda5050() {
        jogoService.fecharJogos(userService.currentUser());
    }

    @GetMapping("/player/game/ajudaTrocaPergunta")
    public void ajudaTrocaPergunta() {
        jogoService.fecharJogos(userService.currentUser());
    }




    @GetMapping("/player/game/terminar")
    public void terminarJogo() {
        jogoService.fecharJogos(userService.currentUser());
    }


}
