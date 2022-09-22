package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.IdSucursalException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.repository.SucursalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* la capa servicio como hasta ahora, su función es implementar la lógica de la api
* ahora con las DTO, se encarga también de realizar la traducción/conversión
* de entidad a DTO, para enviar la información de la dto y no de la entidad
* */

@Service
public class SucursalServiceImpl implements SucursalService {

    private final Logger log = LoggerFactory.getLogger(SucursalServiceImpl.class);

    @Autowired
    private SucursalRepository sucursalRepository;

    ////DTO
    //Empaquetamos los objetos para enviar y recibir los DTO
        //CONVERSION DE ENTIDAD A DTO

    @Override
    public SucursalDTO convertSucursalToDto(Sucursal sucursal) {

        SucursalDTO sucursalDTO = new SucursalDTO();

        sucursalDTO.setIdSucursal(sucursal.getId());
        sucursalDTO.setNombreSucursal(sucursal.getNombre());
        sucursalDTO.setPaisSucursal(sucursal.getPais());

        addPaises(sucursalDTO);

        String paisComprobado = validarPaisUE(sucursalDTO, sucursal);
        sucursalDTO.setTipoSucursal(paisComprobado);

        return sucursalDTO;
    }



    //CONVERSION DE DTO A ENTIDAD
    @Override
    public Sucursal convertDtoToSucursal(SucursalDTO sucursalDTO) {

        Sucursal sucursal = new Sucursal();

        sucursal.setId(sucursalDTO.getIdSucursal());
        sucursal.setNombre(sucursalDTO.getNombreSucursal());
        sucursal.setPais(sucursalDTO.getPaisSucursal());

        return sucursal;

    }


    @Override
    public String validarPaisUE(SucursalDTO sucursalDTO, Sucursal sucursal) {

        String paisComprobado = "";
        String pais;

        boolean encontrado = false;
        int i = 0;

        while (i < sucursalDTO.getListaPaises().size() && !encontrado) {

            pais = sucursalDTO.getListaPaises().get(i);

            if (pais.equalsIgnoreCase(sucursal.getPais())) {

                encontrado = true;
                paisComprobado = "Pais de la UE";

            }
            i++;
        }

        if (!encontrado) {
            paisComprobado = "Pais fuera de la UE";
        }

        return paisComprobado;
    }


    @Override
    public void addPaises(SucursalDTO sucursalDTO) {

        sucursalDTO.getListaPaises().add("Espanya");
        sucursalDTO.getListaPaises().add("Holanda");
        sucursalDTO.getListaPaises().add("Alemania");
        sucursalDTO.getListaPaises().add("Italia");
        sucursalDTO.getListaPaises().add("Francia");

    }


    //// ---- CREATE -----

    @Override
    public SucursalDTO create(SucursalDTO sucursalDto) throws IdSucursalException {

        Sucursal sucursalNew = convertDtoToSucursal(sucursalDto);

        if (sucursalNew.getId() != null){

            throw new IdSucursalException("el campo id no puede tener un valor al introducir una nueva sucursal");

        }

        sucursalRepository.save(sucursalNew);
        log.info("Sucursal añadida correctamente");

        return sucursalDto;
    }

    //// ---- READ -----

    @Override
    public List<SucursalDTO> findAll() {

        List<SucursalDTO> listaSucursalesDTO = new ArrayList<>();
        SucursalDTO sucursalDTO;

        for (Sucursal sucursales : sucursalRepository.findAll()) {

            sucursalDTO = convertSucursalToDto(sucursales);
            listaSucursalesDTO.add(sucursalDTO);

        }

        return listaSucursalesDTO;

    }

    @Override
    public SucursalDTO getOne(Integer id) throws SucursalNotFoundException {

        Optional<Sucursal> sucursalOpt= sucursalRepository.findById(id);

        if (sucursalOpt.isEmpty()) {

            throw new SucursalNotFoundException("No se encuentra la sucursal");

        }

        SucursalDTO sucursalDTO = convertSucursalToDto(sucursalOpt.get());

        return sucursalDTO;
    }

    //// ---- UPDATE ----

    @Override
    public SucursalDTO update(SucursalDTO sucursalDtoNew, Integer id) throws SucursalNotFoundException, IdSucursalException {

        if (id == null){

            throw new IdSucursalException("El id de la sucursal a actualizar no puede ser nulo");

        }

        if (!sucursalRepository.existsById(id)){

            throw new SucursalNotFoundException("La sucursal no existe");

        }


        Optional<Sucursal> sucursalOpt = sucursalRepository.findById(id);

        sucursalOpt.get().setNombre(sucursalDtoNew.getNombreSucursal());
        sucursalOpt.get().setPais(sucursalDtoNew.getPaisSucursal());

        sucursalRepository.save(sucursalOpt.get());

        log.info("Sucursal actualizada correctamente");

        return sucursalDtoNew;


    }

    //// ---- DELETE ----

    @Override
    public void deleteOne(Integer id) throws SucursalNotFoundException {

        if (!sucursalRepository.existsById(id)){

            throw new SucursalNotFoundException("La sucursal no existe");

        }

        sucursalRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {

        sucursalRepository.deleteAll();
    }

    @Override
    public List<SucursalDTO> findListByCountry(String country) {

        List<SucursalDTO> listaSucursalesDto = findAll();

        List<SucursalDTO> sucursalesPaisIndicado = new ArrayList<>();

        for (SucursalDTO lista : listaSucursalesDto) {
            if (lista.getPaisSucursal().equalsIgnoreCase(country)){
                sucursalesPaisIndicado.add(lista);
            }
        }

        return sucursalesPaisIndicado;
    }


}
