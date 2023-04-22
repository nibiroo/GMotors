package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.announcement.AnnouncementCreateDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementResponseDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementUpdateDto;
import com.github.nibiroo.GMotors.dto.carMaker.CarMakerCreateDTO;
import com.github.nibiroo.GMotors.dto.carMaker.CarMakerResponseDTO;
import com.github.nibiroo.GMotors.dto.carMaker.CarMakerUpdateDTO;
import com.github.nibiroo.GMotors.entity.Announcement;
import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.stereotype.Service;

@Service
public class CarMakerMapper {
    public CarMakerResponseDTO modalToResponseDto(CarMaker carMaker) {
        var dto = new CarMakerResponseDTO();
        dto.setId(carMaker.getId());
        dto.setName(carMaker.getName());
        dto.setNativeCountry(carMaker.getNativeCountry());
        return dto;
    }
    public CarMaker responseDtoToModal(CarMakerResponseDTO carMakerResponseDTO) {
        var modal = new CarMaker();
        modal.setId(carMakerResponseDTO.getId());
        modal.setName(carMakerResponseDTO.getName());
        modal.setNativeCountry(carMakerResponseDTO.getNativeCountry());
        return modal;
    }

    public CarMakerCreateDTO modalToCreateDto(CarMaker carMaker) {
        var dto = new CarMakerCreateDTO();
        dto.setName(carMaker.getName());
        dto.setNativeCountry(carMaker.getNativeCountry());
        return dto;
    }
    public CarMaker createDtoToModal(CarMakerCreateDTO carMakerCreateDto) {
        var modal = new CarMaker();
        modal.setName(carMakerCreateDto.getName());
        modal.setNativeCountry(carMakerCreateDto.getNativeCountry());
        return modal;
    }

    public CarMakerUpdateDTO modalToUpdateDto(CarMaker carMaker) {
        var dto = new CarMakerUpdateDTO();
        dto.setId(carMaker.getId());
        dto.setName(carMaker.getName());
        dto.setNativeCountry(carMaker.getNativeCountry());
        return dto;
    }
    public CarMaker updateDtoToModal(CarMakerUpdateDTO carMakerUpdateDTO) {
        var modal = new CarMaker();
        modal.setId(carMakerUpdateDTO.getId());
        modal.setName(carMakerUpdateDTO.getName());
        modal.setNativeCountry(carMakerUpdateDTO.getNativeCountry());
        return modal;
    }
}
