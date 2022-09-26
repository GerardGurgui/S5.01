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



//    @GetMapping("register")
//    public String sucursalRegistration(Model model){
//
//        SucursalDTO sucursalDTO = new SucursalDTO();
//        model.addAttribute("sucursalDTO", sucursalDTO);
//
//        List<String> paisesForm = Arrays.asList("Espanya", "Alemania", "Holanda", "Francia", "Italia");
//        model.addAttribute("paisesForm",paisesForm);
//
//        return "register-form"; //devolvemos la vista, nombre del archivo html con su configuracion
//
//    }
//
//    @PostMapping("/register/save")
//    public String submitForm(Model model,
//                             @ModelAttribute("sucursalDTO") SucursalDTO sucursalDTO) throws IdSucursalException {
//
//        model.addAttribute("sucursalDTO",sucursalDTO);
//
//        sucursalService.create(sucursalDTO);
//
//        return "register-success";
//    }

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

        //obtener sucursal existente de bdb
        SucursalDTO existingSucursal = sucursalService.getOne(id);

        existingSucursal.setIdSucursal(id);
        existingSucursal.setNombreSucursal(sucursal.getNombre());
        existingSucursal.setPaisSucursal(sucursal.getPais());

        sucursalService.update(existingSucursal, id);


        return "redirect:/sucursals";

    }


    @GetMapping("/sucursals/{id}")
    public String deleteSucursal(@PathVariable Integer id) throws SucursalNotFoundException {

        sucursalService.deleteOne(id);

        return "redirect:/sucursals";

    }

}
