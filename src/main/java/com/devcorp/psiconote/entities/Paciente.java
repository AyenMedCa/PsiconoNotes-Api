package com.devcorp.psiconote.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String email;
    private String telefono;
    private String acudiente;
    private String telEmergencia;
    private String telAcudiente;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "psicologo",referencedColumnName = "id")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "grado", referencedColumnName = "id")
    private Grado grado;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario",referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "paciente",fetch = FetchType.EAGER)
    private List<Sesion> sesiones;
}
