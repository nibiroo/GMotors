package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarMakerService {

    List<CarMaker> findAllCarMaker(int pageNo, int recordCount);

    CarMaker getByIdCarMaker(Long id);

    List<Vehicle> findAllVehiclesByIdCarMaker(Long id, int pageNo, int recordCount);

    CarMaker save(CarMaker carMaker);

    CarMaker updateById(Long id, CarMaker carMaker);

    void deleteById(Long id);
}
