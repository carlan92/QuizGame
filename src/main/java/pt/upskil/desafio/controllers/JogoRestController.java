package pt.upskil.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.upskil.desafio.entities.Jogo;
import pt.upskil.desafio.entities.Pergunta;
import pt.upskil.desafio.entities.User;
import pt.upskil.desafio.exceptions.AjudaAlreadyUsedException;
import pt.upskil.desafio.exceptions.NoGameActiveException;
import pt.upskil.desafio.exceptions.ObterPerguntasException;
import pt.upskil.desafio.services.JogoService;
import pt.upskil.desafio.services.UserService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@RestController
public class JogoRestController {
    @Autowired
    UserService userService;

    @Autowired
    JogoService jogoService;

    @GetMapping("/player/game/ajudaPublico")
    public List<Double> ajudaPublico() {
        User user = userService.currentUser();
        try {
            return jogoService.usarAjudaPublico(user);
        } catch (NoGameActiveException e) {
            e.printStackTrace();
            return null;
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
            return null;
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
    public List<String> ajudaTrocaPergunta() {
        User user = userService.currentUser();
        try {
            Pergunta novaPergunta = jogoService.usarTrocaPergunta(user);
            List<String> perguntaParts = new ArrayList<>();
            perguntaParts.add(novaPergunta.getDescricao());
            for (int i = 0; i < Pergunta.NUM_RESPOSTAS; i++) {
                perguntaParts.add(novaPergunta.getRespostas().get(i).getTexto());
            }
            return perguntaParts;
        } catch (NoGameActiveException e) {
            e.printStackTrace();
            return null;
        } catch (AjudaAlreadyUsedException e) {
            e.printStackTrace(); //TODO fazer apercer mensagem no html
            return null;
        } catch (ObterPerguntasException e) {
            e.printStackTrace();
            return null;
        }
    }




    @GetMapping("/player/game/terminar")
    public void terminarJogo() {
        jogoService.fecharJogos(userService.currentUser());
    }


}
