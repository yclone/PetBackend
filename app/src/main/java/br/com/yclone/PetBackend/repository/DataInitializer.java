package br.com.yclone.PetBackend.repository;

import br.com.yclone.PetBackend.Model.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository usuarioRepository;

    public DataInitializer(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User usuario = new User();
        usuario.setUsername("teste@teste.com");
        usuario.setEmail("teste@teste.com");
        usuario.setNome("teste");
        usuario.setSobrenome("teste");
        usuario.setPassword("123@qweqwe");

        usuarioRepository.save(usuario);
    }
}
