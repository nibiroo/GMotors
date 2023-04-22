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
@Table(name = "vehicle")
public class    Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Long year;

    @Column(name = "transmission")
    private Boolean isAutomatic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carmaker")
    private CarMaker carMaker;

    @ManyToMany
    @JoinTable(
            name = "optional_vehicle",
            joinColumns = @JoinColumn(name = "id_vehicle"),
            inverseJoinColumns = @JoinColumn(name = "id_optional")
    )
    private List<Optional> optional;

}
