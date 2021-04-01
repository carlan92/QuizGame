package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.User;
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
        jogoService.usarAjudaPublico(user);


    }

    @GetMapping("/player/game/ajuda5050")
    public List<Integer> ajuda5050() {
        User user = userService.currentUser();
        return jogoService.usar5050(user);
    }

    @GetMapping("/player/game/ajudaTrocaPergunta")
    public void ajudaTrocaPergunta() {
        User user = userService.currentUser();
        jogoService.usarTrocaPergunta(user);

    }




    @GetMapping("/player/game/terminar")
    public void terminarJogo() {
        jogoService.fecharJogos(userService.currentUser());
    }


}
