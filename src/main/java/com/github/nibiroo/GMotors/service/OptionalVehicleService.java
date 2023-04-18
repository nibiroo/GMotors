package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.OptionalVehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionalVehicleService {
    List<OptionalVehicle> getAllOptionalVehicleFind();

    OptionalVehicle getByIdOptionalVehicleFind(Long id);

    OptionalVehicle save(OptionalVehicle optionalVehicle);

    OptionalVehicle updateById(Long id, OptionalVehicle optionalVehicle);

    void deleteById(Long id);
}
