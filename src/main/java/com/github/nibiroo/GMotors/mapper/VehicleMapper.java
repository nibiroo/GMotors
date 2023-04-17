package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.VehicleDTO;
import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapper {
    public VehicleDTO entityToDTO (Vehicle entity) {
        var dto = new VehicleDTO();

        dto.setId(entity.getId());
        dto.setKm(entity.getKm());
        dto.setModel(entity.getModel());
        dto.setYear(entity.getYear());
        dto.setCarMaker(entity.getCarMaker());
        dto.setOptionalVehicle(entity.getOptionalVehicle());
        dto.setIsAutomatic(entity.getIsAutomatic());

        return dto;
    }
}
