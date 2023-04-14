package com.github.nibiroo.GMotors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;

    @Column(name = "price")
    private float price;

    @Column(name = "city")
    private String city;
}
