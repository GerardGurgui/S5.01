package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormularyController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalRepository sucursalRepository;



    @GetMapping("/sucursals")
    public String showAll(Model model){

        List<SucursalDTO> sucursals = sucursalService.findAll();

        model.addAttribute("sucursals", sucursals);

        return "sucursals";

    }

    @GetMapping("/sucursals/new")
    public String createSucursal(Model model){

        Sucursal sucursal = new Sucursal();
        model.addAttribute("sucursal",sucursal);
        return "create_sucursal";

    }

    @PostMapping("/sucursals")
    public String saveSucursal(@ModelAttribute("sucursal") Sucursal sucursal) throws IdSucursalException {

        SucursalDTO sucursalDTO = sucursalService.convertSucursalToDto(sucursal);

        sucursalService.create(sucursalDTO);

        return "redirect:/sucursals";

    }


    @GetMapping("/sucursals/edit/{id}")
    public String editSucursal(@PathVariable Integer id, Model model) throws SucursalNotFoundException {

        SucursalDTO sucursalDto = sucursalService.getOne(id);

        Sucursal sucursal = sucursalService.convertDtoToSucursal(sucursalDto);

        model.addAttribute("sucursal", sucursal);

        return "edit_sucursal";
    }

    @PostMapping("/sucursals/{id}")
    public String updateSucursal(@PathVariable Integer id,
                                @ModelAttribute("sucursal")Sucursal sucursal,
                                Model model) throws SucursalNotFoundException, IdSucursalException {

        SucursalDTO existingSucursal = sucursalService.convertSucursalToDto(sucursal);

        sucursalService.update(existingSucursal, id);

        return "redirect:/sucursals";

    }


    @GetMapping("/sucursals/{id}")
    public String deleteSucursal(@PathVariable Integer id) throws SucursalNotFoundException {

        sucursalService.deleteOne(id);

        return "redirect:/sucursals";

    }

}
