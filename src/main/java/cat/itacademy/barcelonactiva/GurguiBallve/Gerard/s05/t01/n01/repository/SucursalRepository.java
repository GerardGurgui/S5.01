package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.repository;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* Importante almacenar en la bdd la entidad y no la DTO
* en el repositorio le indicamos la ENTIDAD
* */

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {



}
