package org.acme.domain.model;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor // gera construtor com todos os campos
@NoArgsConstructor  // construtor vazio (requerido por JPA se for o caso)
@Builder            // para facilitar a criação via builder
public class Experiment {
    private UUID id;
    private String name;
    private String description;
}
