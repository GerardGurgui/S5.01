package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/*
 * DTO = Data Transfer Object
 * tipos de objetos que sirven únicamente para transportar los datos de las entidades
 * Implementa la interfaz serializable para poder enviar el objeto por la red y recuperar su información
 * */


public class SucursalDTO implements Serializable {

    private Integer idSucursal;
    private String nombreSucursal;
    private String paisSucursal;
    private String tipoSucursal;


    public SucursalDTO(){
        super();
    }

    ////////

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }


}
