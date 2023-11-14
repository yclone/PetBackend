package br.com.yclone.PetBackend.repository;

import br.com.yclone.PetBackend.Model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
