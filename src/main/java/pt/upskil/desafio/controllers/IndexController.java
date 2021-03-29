package pt.upskil.desafio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("name", "Grupo B2");
        return "index";
    }

}
