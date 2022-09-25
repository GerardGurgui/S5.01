package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service;


import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SucursalValidationCountryImpl implements SucursalValidationCountry{

    @Override
    public  List<String> addUeCountries() {

        List<String> listaPaises = new ArrayList<>();

        listaPaises.add("Espanya");
        listaPaises.add("Holanda");
        listaPaises.add("Alemania");
        listaPaises.add("Italia");
        listaPaises.add("Francia");

        return listaPaises;
    }

    @Override
    public String validateUeCountry(List<String> paisesUE, Sucursal sucursal) {

        String paisComprobado = "";
        String pais;

        boolean encontrado = false;
        int i = 0;

        while (i < paisesUE.size() && !encontrado) {

            pais = paisesUE.get(i);

            if (pais.equalsIgnoreCase(sucursal.getPais())) {

                encontrado = true;
                paisComprobado = "UE Country";

            }
            i++;
        }

        if (!encontrado) {
            paisComprobado = "Not a UE country";
        }

        return paisComprobado;
    }
}
