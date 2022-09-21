package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import jdk.jfr.RecordingState;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ISucursalController {

    //// CRUD

     List<SucursalDTO> getSucursals();

     ResponseEntity<SucursalDTO> getOneSucursal(Integer id) throws SucursalNotFoundException;

     ResponseEntity<SucursalDTO> addSucursal(SucursalDTO sucursalDTO) throws IdSucursalException;

    ResponseEntity<SucursalDTO> updateSucursal(SucursalDTO sucursalDTO, Integer id) throws SucursalNotFoundException, IdSucursalException;

}
