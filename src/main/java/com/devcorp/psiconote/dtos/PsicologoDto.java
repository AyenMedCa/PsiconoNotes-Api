package com.devcorp.psiconote.dtos;

import java.util.List;

public record PsicologoDto(Long id,
                           String nombre,
                           String apellido,
                           String estado,
                           int edad,
                           String telefono
                           /*List<PacienteDto> pacientes*/) {}

