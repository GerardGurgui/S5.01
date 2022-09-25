package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;


import java.util.List;

public interface SucursalService {

    ////DTO

    SucursalDTO convertSucursalToDto(Sucursal sucursal);

    Sucursal convertDtoToSucursal(SucursalDTO sucursalDTO);




    //// CRUD

    List<SucursalDTO> findAll();

    SucursalDTO getOne(Integer id) throws SucursalNotFoundException;

    SucursalDTO create(SucursalDTO sucursalDTO) throws IdSucursalException;

    SucursalDTO update(SucursalDTO sucursalDTO, Integer id) throws SucursalNotFoundException, IdSucursalException;

    void deleteOne(Integer id) throws SucursalNotFoundException;

    void deleteAll();

    List<SucursalDTO> findListByCountry(String country);


}
