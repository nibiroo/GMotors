package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.Optional;
import com.github.nibiroo.GMotors.entity.Vehicle;
import com.github.nibiroo.GMotors.repository.OptionalRepository;
import com.github.nibiroo.GMotors.repository.VehicleRepository;
import com.github.nibiroo.GMotors.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final OptionalRepository optionalRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, OptionalRepository optionalRepository) {
        this.vehicleRepository = vehicleRepository;
        this.optionalRepository = optionalRepository;
    }

    @Override
    public List<Vehicle> findAllVehicle() {
        return this.vehicleRepository.findAll();
    }

    @Override
    public Vehicle getByIVehicle(Long id) {
        return this.vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        Vehicle vehicleInt = new Vehicle();
        vehicleInt.setYear(vehicle.getYear());
        vehicleInt.setModel(vehicle.getModel());
        vehicleInt.setCarMaker(vehicle.getCarMaker());
        vehicleInt.setIsAutomatic(vehicle.getIsAutomatic());

        List<Optional> optionals = new ArrayList<>();
        for (Optional eachoptional : vehicle.getOptional()) {
            Optional optional = optionalRepository.findById(eachoptional.getId())
                                                    .orElseThrow(() -> new ResponseStatusException(
                                                                            HttpStatus.NOT_FOUND,
                                                                            "There isn't optional with id " + eachoptional.getId()));
            optionals.add(optional);
        }

        vehicleInt.setOptional(optionals);

        return this.vehicleRepository.save(vehicleInt);
    }

    @Override
    public void addOptional(Long vehicleId, Long optionalId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't vehicle with id " + vehicleId));
        Optional optional = optionalRepository.findById(optionalId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't optional with id " + optionalId));
        vehicle.getOptional().add(optional);
        vehicleRepository.save(vehicle);
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
