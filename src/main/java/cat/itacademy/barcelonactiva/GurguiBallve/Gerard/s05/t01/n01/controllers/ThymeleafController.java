package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
*Thymeleaf nos proporciona plantillas html para poder tener un apartado visual.
* En este caso su controlador será con anotación controller y no restController, ya que
* trabajaremos con html
* */

@Controller
public class ThymeleafController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
