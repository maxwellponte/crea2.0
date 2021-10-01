package br.com.nestec.crea20;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan({"br.com.nestec.crea20."})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	CommandLineRunner run(UsuarioService usuarioService){
		return args -> {
			usuarioService.salvarRole(new Role(null, "Admin"));
			usuarioService.salvarRole(new Role(null, "fiscal"));
			usuarioService.salvarRole(new Role(null, "gestor"));
		};
	}
}

