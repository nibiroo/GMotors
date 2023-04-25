package com.github.nibiroo.GMotors.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;

    @Column(name = "price", precision = 20, scale = 2)
    private BigDecimal price;

    @Column(name = "km", precision = 20, scale = 2)
    private BigDecimal km;

    @Column(name = "city")
    private String city;
}
