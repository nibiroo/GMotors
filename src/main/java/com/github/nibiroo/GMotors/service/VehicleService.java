package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    List<Vehicle> getAllVehicleFind();

    Vehicle getByIVehicleFind(Long id);

    Vehicle save(Vehicle carMaker);

    Vehicle updateById(Long id, Vehicle carMakerDTO);

    void deleteById(Long id);
}
