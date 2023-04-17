package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.dto.CarMakerDTO;
import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarMakerService {

    List<CarMaker> getAllCarMakerFind();

    CarMaker getByIdCarMakerFind(Long id);

    CarMaker save(CarMaker carMaker);

    CarMaker updateById(Long id, CarMaker carMaker);

    void deleteById(Long id);
}
