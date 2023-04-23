package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import com.github.nibiroo.GMotors.repository.CarMakerRepository;
import com.github.nibiroo.GMotors.repository.VehicleRepository;
import com.github.nibiroo.GMotors.service.CarMakerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarMakerServiceImpl implements CarMakerService {

    private final CarMakerRepository carMakerRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public CarMakerServiceImpl(CarMakerRepository carMakerRepository, VehicleRepository vehicleRepository) {
        this.carMakerRepository = carMakerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<CarMaker> findAllCarMaker() {
        return this.carMakerRepository.findAll();
    }

    @Override
    public CarMaker getByIdCarMaker(Long id) {
        return this.carMakerRepository.findById(id)
                                        .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Vehicle> findAllVehiclesByIdCarMaker(Long id) {
        return this.vehicleRepository.findByCarMakerId(id);
    }

    @Override
    public CarMaker save(CarMaker carMaker) {
        return this.carMakerRepository.save(carMaker);
    }

    @Override
    public CarMaker updateById(Long id, CarMaker carMaker) {
        this.carMakerRepository
                .findById(id)
                .map(cmkrExist -> {
                    carMaker.setId(cmkrExist.getId());
                    this.carMakerRepository.save(carMaker);
                    return cmkrExist;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't CarMaker with id " + id));
        return carMaker;
    }

    @Override
    public void deleteById(Long id) {
        this.carMakerRepository.deleteById(id);
    }
}
