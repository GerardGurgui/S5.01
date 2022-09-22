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
		Sucursal sucursal3 = new Sucursal(3,"bcn2","Espanya");
		Sucursal sucursal4 = new Sucursal(4,"alem1","Alemania");
		Sucursal sucursal5 = new Sucursal(5,"argent1","Argentina");
		Sucursal sucursal6 = new Sucursal(6,"brasi1","Brasil");
		Sucursal sucursal7 = new Sucursal(7,"holand2","Holanda");
		Sucursal sucursal8 = new Sucursal(8,"bcn3","Espanya");

		sucursalRepository.save(sucursal);
		sucursalRepository.save(sucursal2);
		sucursalRepository.save(sucursal3);
		sucursalRepository.save(sucursal4);
		sucursalRepository.save(sucursal5);
		sucursalRepository.save(sucursal6);
		sucursalRepository.save(sucursal7);
		sucursalRepository.save(sucursal8);

	}

}
