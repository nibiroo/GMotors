package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.CarMakerDTO;
import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.stereotype.Service;

@Service
public class CarMakerMapper {
    public CarMakerDTO entityToDTO(CarMaker entity) {
        var dto = new CarMakerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNativeCountry(entity.getNativeCountry());
        return dto;
    }
}
