package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;

import java.util.List;

public interface SucursalValidationCountry {


    public List<String> addUeCountries();

    public String validateUeCountry(List<String> paisesUE, Sucursal sucursal);
}
