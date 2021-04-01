package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.services.UserService;

import java.util.HashMap;

@RestController
public class JogoRestController {
    @Autowired
    UserService userService;


    @GetMapping("/player/game/terminar")
    public void terminarJogo() {

        // TODO user.setJogoCorrente(null);


        /*System.out.println("coisas");
        HashMap<String,String> map = new HashMap<>();
        map.put("response","aqui vai resposta");*/
    }


}
