package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.carMaker.CarMakerCreateDTO;
import com.github.nibiroo.GMotors.dto.carMaker.CarMakerResponseDTO;
import com.github.nibiroo.GMotors.dto.carMaker.CarMakerUpdateDTO;
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
@RequestMapping("/api/carmakers/")
public class CarMakerController {

    private final CarMakerService carMakerService;
    private final CarMakerMapper carMakerMapper;

    @Autowired
    public CarMakerController(CarMakerService carMakerService, CarMakerMapper carMakerMapper) {
        this.carMakerService = carMakerService;
        this.carMakerMapper = carMakerMapper;
    }

    @GetMapping
    public ResponseEntity<APIListResponse<CarMakerResponseDTO>> findAll() {
        var carMakerDTOS = this.carMakerService.findAllCarMaker()
                                                .stream()
                                                .map(this.carMakerMapper::modalToResponseDto)
                                                .collect(Collectors.toList());
        var response = new APIListResponse<>(carMakerDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CarMakerResponseDTO> findById(@PathVariable Long id) {
        var carMakerModel = this.carMakerService.getByIdCarMaker(id);
        var carMakerDTO = this.carMakerMapper.modalToResponseDto(carMakerModel);

        return new ResponseEntity<>(carMakerDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CarMakerCreateDTO> save(@RequestBody CarMakerCreateDTO carMakerCreateDTO) {
        var model = carMakerMapper.createDtoToModal(carMakerCreateDTO);
        var dto = carMakerMapper.modalToCreateDto(this.carMakerService.save(model));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CarMakerUpdateDTO> update(@PathVariable Long id, @RequestBody CarMakerUpdateDTO carMakerUpdateDTO) {
        var model = carMakerMapper.updateDtoToModal(carMakerUpdateDTO);
        var dto = carMakerMapper.modalToUpdateDto(this.carMakerService.updateById(id, model));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.carMakerService.deleteById(id);
    }
}
