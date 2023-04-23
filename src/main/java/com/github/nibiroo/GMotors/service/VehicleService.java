package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    List<Vehicle> findAllVehicle();

    Vehicle getByIVehicle(Long id);

    Vehicle save(Vehicle carMaker);

    Vehicle updateById(Long id, Vehicle carMakerDTO);

    void deleteById(Long id);
}
