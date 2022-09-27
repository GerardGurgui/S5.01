package cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01;

import cat.itacademy.barcelonactiva.GurguiBallve.Gerard.s05.t01.n01.repository.SucursalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class S05T01N01GurguiBallveGerardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(S05T01N01GurguiBallveGerardApplication.class, args);
		SucursalRepository sucursalRepository = context.getBean(SucursalRepository.class);


	}

}
