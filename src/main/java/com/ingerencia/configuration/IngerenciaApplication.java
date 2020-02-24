package com.ingerencia.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan( basePackages={"com.ingerencia"} )
@EnableScheduling
@EnableJpaRepositories("com.ingerencia.repository")
@EntityScan( basePackages= {"com.ingerencia.dto"} )
public class IngerenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngerenciaApplication.class, args);
	}

}
