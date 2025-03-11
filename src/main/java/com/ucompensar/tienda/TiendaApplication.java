package com.ucompensar.tienda;

import com.ucompensar.tienda.persistence.entities.Usuario;
import com.ucompensar.tienda.persistence.repository.UsuarioDao;
import com.ucompensar.tienda.services.UsuarioServices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class TiendaApplication implements CommandLineRunner {

	private final UsuarioDao usuarioDao;

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Usuario> usuario = usuarioDao.findByUsername("admin");
		if (usuario.isEmpty()) {
			Usuario admin = Usuario.builder()
					.name("admin")
					.lastname("admin")
					.username("admin")
					.password("admin")
					.build();
			usuarioDao.save(admin);
		}
	}
}
