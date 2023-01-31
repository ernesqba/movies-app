package uah.es.moviesfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RootController {
    @GetMapping(value = { "/", "/home", "" })
    public String home(Model model) {
        return "home";
    }

}
