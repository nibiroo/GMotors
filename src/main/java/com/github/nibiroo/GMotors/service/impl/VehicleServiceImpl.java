package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.dto.CarMakerDTO;
import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import com.github.nibiroo.GMotors.repository.CarMakerRepository;
import com.github.nibiroo.GMotors.repository.VehicleRepository;
import com.github.nibiroo.GMotors.service.CarMakerService;
import com.github.nibiroo.GMotors.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicleFind() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle getByIVehicleFind(Long id) {
        return this.vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateById(Long id, Vehicle vehicle) {
        this.vehicleRepository.findById(id).map(it -> {
           vehicle.setId(it.getId());
           this.vehicleRepository.save(vehicle);
           return it;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't vehicle with id " + id));


        return vehicle;
    }

    @Override
    public void deleteById(Long id) {
        this.vehicleRepository.deleteById(id);
    }
}
