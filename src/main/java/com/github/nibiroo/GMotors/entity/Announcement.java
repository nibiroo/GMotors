package com.github.nibiroo.GMotors.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "announcement")
public class Announcement {
    // Um anùncio tem:
        // Id anúncio
        // Carro
        // Opcionais do carro
        // Preço
        // Cidade
}
