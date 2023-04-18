package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.OptionalVehicleDTO;
import com.github.nibiroo.GMotors.entity.OptionalVehicle;
import org.springframework.stereotype.Service;

@Service
public class OptionalVehicleMapper {
    public OptionalVehicleDTO entityToDTO(OptionalVehicle optionalVehicle) {
        var dto = new OptionalVehicleDTO();
        dto.setId(optionalVehicle.getId());
        dto.setShortDescription(optionalVehicle.getShortDescription());
        return dto;
    }
}
