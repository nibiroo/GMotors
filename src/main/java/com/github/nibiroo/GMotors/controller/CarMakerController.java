package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.CarMakerDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.mapper.CarMakerMapper;
import com.github.nibiroo.GMotors.service.CarMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/carmaker/")
public class CarMakerController {

    private final CarMakerService carMakerService;
    private final CarMakerMapper carMakerMapper;

    @Autowired
    public CarMakerController(CarMakerService carMakerService, CarMakerMapper carMakerMapper) {
        this.carMakerService = carMakerService;
        this.carMakerMapper = carMakerMapper;
    }

    @GetMapping
    public ResponseEntity<APIListResponse<CarMakerDTO>> findAll() {
        var carMakerDTOS = this.carMakerService.getAllCarMakerFind()
                                                .stream()
                                                .map(this.carMakerMapper::entityToDTO)
                                                .collect(Collectors.toList());
        var response = new APIListResponse<>(carMakerDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarMakerDTO> findById(@PathVariable Long id) {
        var carMakerModel = this.carMakerService.getByIdCarMakerFind(id);
        var carMakerDTO = this.carMakerMapper.entityToDTO(carMakerModel);

        return new ResponseEntity<>(carMakerDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CarMaker> save(@RequestBody CarMaker carMaker) {
        return new ResponseEntity<>(this.carMakerService.save(carMaker), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CarMaker> update(@PathVariable Long id, @RequestBody CarMaker carMaker) {
        return new ResponseEntity<>(this.carMakerService.updateById(id, carMaker), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.carMakerService.deleteById(id);
    }
}
