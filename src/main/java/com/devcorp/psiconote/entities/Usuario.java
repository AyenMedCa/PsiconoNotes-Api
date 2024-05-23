package com.devcorp.psiconote.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String userName;
    private String password;

    @OneToOne(mappedBy = "usuario")
    private Psicologo psicologo;

    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    @ManyToMany
    @JoinTable(
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name="id_rol"))
    private Set<Rol> roles = new HashSet<>();
}