package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.OptionalVehicleDTO;
import com.github.nibiroo.GMotors.entity.Optional;
import org.springframework.stereotype.Service;

@Service
public class OptionalVehicleMapper {
    public OptionalVehicleDTO entityToDTO(Optional optional) {
        var dto = new OptionalVehicleDTO();
        dto.setId(optional.getId());
        dto.setShortDescription(optional.getShortDescription());
        return dto;
    }
}
