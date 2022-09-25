package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormularyController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("register")
    public String sucursalRegistration(Model model){

        SucursalDTO sucursalDTO = new SucursalDTO();
        model.addAttribute("sucursalDTO", sucursalDTO);

        List<String> paisesForm = Arrays.asList("Espanya", "Alemania", "Holanda", "Francia", "Italia");
        model.addAttribute("paisesForm",paisesForm);

        return "register-form";

    }

    @PostMapping("/register/save")
    public String submitForm(Model model,
                             @ModelAttribute("sucursalDTO") SucursalDTO sucursalDTO) throws IdSucursalException {

        model.addAttribute("sucursalDTO",sucursalDTO);

        sucursalService.create(sucursalDTO);

        return "register-success";
    }

    @GetMapping("/iteration")
    public String iteration(Model model){

        List<SucursalDTO> sucusDto = sucursalService.findAll();

        model.addAttribute("sucusDto", sucusDto);

        return "iteration";

    }


}
