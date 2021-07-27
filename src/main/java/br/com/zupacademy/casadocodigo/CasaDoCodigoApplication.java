package br.com.zupacademy.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDateTime;

@SpringBootApplication
public class CasaDoCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaDoCodigoApplication.class, args);

		System.out.println(LocalDateTime.now());
		System.out.println(Instant.now());
	}

}
