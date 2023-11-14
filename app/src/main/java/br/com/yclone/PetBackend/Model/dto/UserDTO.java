package br.com.yclone.PetBackend.Model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private long id;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String password;
}
