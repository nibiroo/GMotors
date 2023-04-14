package com.github.nibiroo.GMotors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class    Vehicle {

    // O carro tem:
        // Modelo
        // Ano
        // Montadora
        // Opcionais -> Todo carro tem opcional
        // Cambio

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Long year;

    @Column(name = "transmission")
    private Boolean isAutomatic;

    @Column(name = "km")
    private float km;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carmaker")
    private CarMaker carMaker;

    @OneToMany
    @JoinColumn(name = "id_optional")
    private OptionalVehicle optionalVehicle;

}
