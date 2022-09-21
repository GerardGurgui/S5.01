package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.models.Sucursal;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.service.SucursalServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class S05T01N01GurguiBallveGerardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(S05T01N01GurguiBallveGerardApplication.class, args);
		SucursalRepository sucursalRepository = context.getBean(SucursalRepository.class);

		SucursalServiceImpl sucursalService = new SucursalServiceImpl();

		Sucursal sucursal = new Sucursal(1,"barceloning","Espanya");
		Sucursal sucursal2 = new Sucursal(2,"holanding","Holanda");
		Sucursal sucursal3 = new Sucursal(3,"argentining","Argentina");

		sucursalRepository.save(sucursal);
		sucursalRepository.save(sucursal2);
		sucursalRepository.save(sucursal3);

		SucursalDTO sucursalDTO = sucursalService.convertSucursalToDto(sucursal);

		System.out.println(sucursalDTO.getIdSucursal());
		System.out.println(sucursalDTO.getPaisSucursal());
		System.out.println(sucursalDTO.getNombreSucursal());
		System.out.println(sucursalDTO.getTipoSucursal());

		for (String listaPaise : sucursalDTO.getListaPaises()) {
			System.out.println(listaPaise);
		}


		//CORRECTE CREC--> MOSTRAR INFO AMB LA DTO




	}

}
