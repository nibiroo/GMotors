package com.github.nibiroo.GMotors.dto.vehicle;

import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleUpdateDTO {

    private Long id;

    private String model;

    private Long year;

    private Boolean isAutomatic;

    private CarMaker carMaker;

    private List<Optional> optional;
}
