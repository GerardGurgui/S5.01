package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController implements ISucursalController {


    @Autowired
    private SucursalService sucursalService;



    //// ---- GET -----

    @Override
    @GetMapping("/findAll")
    public List<SucursalDTO> getSucursals() {

        return sucursalService.findAll();
    }

    @Override
    @GetMapping("/findOne/{id}")
    public ResponseEntity<SucursalDTO> getOneSucursal(@PathVariable Integer id) throws SucursalNotFoundException {

        return ResponseEntity.ok(sucursalService.getOne(id));

    }


    //// ---- POST -----

    @Override
    @PostMapping("/add")
    public ResponseEntity<SucursalDTO> addSucursal(@RequestBody SucursalDTO sucursalDTO) throws IdSucursalException {

        return new ResponseEntity<>(sucursalService.create(sucursalDTO), HttpStatus.CREATED);
    }


    //// ---- PUT ----

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@RequestBody SucursalDTO sucursalDTO,
                                                      @PathVariable Integer id)
                                                      throws SucursalNotFoundException, IdSucursalException {

        SucursalDTO sucursalDtoUpdate = sucursalService.update(sucursalDTO,id);

        return new ResponseEntity<>(sucursalDtoUpdate, HttpStatus.OK);
    }



    //// ---- DELETE ----


}
