package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarMakerService {

    List<CarMaker> findAllCarMaker();

    CarMaker getByIdCarMaker(Long id);

    CarMaker save(CarMaker carMaker);

    CarMaker updateById(Long id, CarMaker carMaker);

    void deleteById(Long id);
}
