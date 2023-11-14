package br.com.yclone.PetBackend.service;

import br.com.yclone.PetBackend.Model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

	User save(User any);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    ResponseEntity<User> updateUser(Long id, User user);

}
