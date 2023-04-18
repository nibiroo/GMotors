package com.github.nibiroo.GMotors.dto;

import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.OptionalVehicle;
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
public class VehicleDTO {

    private Long id;

    private String model;

    private Long year;

    private Boolean isAutomatic;

    private CarMaker carMaker;

    @ElementCollection
    private List<Long> optionalVehicleIds;

}
