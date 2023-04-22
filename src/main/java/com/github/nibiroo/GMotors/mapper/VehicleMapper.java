package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.vehicle.VehicleCreateDTO;
import com.github.nibiroo.GMotors.dto.vehicle.VehicleResponseDTO;
import com.github.nibiroo.GMotors.dto.vehicle.VehicleUpdateDTO;
import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapper {
    public VehicleResponseDTO modalToResponseDto(Vehicle vehicle) {
        var dto = new VehicleResponseDTO();
        dto.setId(vehicle.getId());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setCarMaker(vehicle.getCarMaker());
        dto.setOptional(vehicle.getOptional());
        dto.setIsAutomatic(vehicle.getIsAutomatic());
        return dto;
    }
    public Vehicle responseDtoToModal(VehicleResponseDTO vehicleResponseDTO) {
        var modal = new Vehicle();
        modal.setId(vehicleResponseDTO.getId());
        modal.setModel(vehicleResponseDTO.getModel());
        modal.setYear(vehicleResponseDTO.getYear());
        modal.setCarMaker(vehicleResponseDTO.getCarMaker());
        modal.setOptional(vehicleResponseDTO.getOptional());
        modal.setIsAutomatic(vehicleResponseDTO.getIsAutomatic());
        return modal;
    }

    public VehicleCreateDTO modalToCreateDto(Vehicle vehicle) {
        var dto = new VehicleCreateDTO();
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setCarMaker(vehicle.getCarMaker());
        dto.setOptional(vehicle.getOptional());
        dto.setIsAutomatic(vehicle.getIsAutomatic());
        return dto;
    }
    public Vehicle createDtoToModal(VehicleCreateDTO vehicleCreateDTO) {
        var modal = new Vehicle();
        modal.setModel(vehicleCreateDTO.getModel());
        modal.setYear(vehicleCreateDTO.getYear());
        modal.setCarMaker(vehicleCreateDTO.getCarMaker());
        modal.setOptional(vehicleCreateDTO.getOptional());
        modal.setIsAutomatic(vehicleCreateDTO.getIsAutomatic());
        return modal;
    }

    public VehicleUpdateDTO modalToUpdateDto(Vehicle vehicle) {
        var dto = new VehicleUpdateDTO();
        dto.setId(vehicle.getId());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setCarMaker(vehicle.getCarMaker());
        dto.setOptional(vehicle.getOptional());
        dto.setIsAutomatic(vehicle.getIsAutomatic());
        return dto;
    }
    public Vehicle updateDtoToModal(VehicleUpdateDTO vehicleUpdateDTO) {
        var modal = new Vehicle();
        modal.setId(vehicleUpdateDTO.getId());
        modal.setModel(vehicleUpdateDTO.getModel());
        modal.setYear(vehicleUpdateDTO.getYear());
        modal.setCarMaker(vehicleUpdateDTO.getCarMaker());
        modal.setOptional(vehicleUpdateDTO.getOptional());
        modal.setIsAutomatic(vehicleUpdateDTO.getIsAutomatic());
        return modal;
    }
}
