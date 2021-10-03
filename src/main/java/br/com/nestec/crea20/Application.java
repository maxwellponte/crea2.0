package br.com.nestec.crea20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan({"br.com.nestec.crea20."})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		StartUp s = new StartUp();
		s.afterPropertiesSet();
	}
}

