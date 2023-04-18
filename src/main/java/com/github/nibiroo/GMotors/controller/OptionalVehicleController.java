package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.OptionalVehicleDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.entity.OptionalVehicle;
import com.github.nibiroo.GMotors.mapper.OptionalVehicleMapper;
import com.github.nibiroo.GMotors.service.OptionalVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/optionalvehicle/")
public class OptionalVehicleController {
    private final OptionalVehicleService optionalVehicleService;
    private final OptionalVehicleMapper optionalVehicleMapper;

    @GetMapping
    public ResponseEntity<APIListResponse<OptionalVehicleDTO>> findAll() {
        var optionalVehicleDTOS = this.optionalVehicleService.getAllOptionalVehicleFind()
                                                                .stream()
                                                                .map(this.optionalVehicleMapper::entityToDTO)
                                                                .collect(Collectors.toList());
        var response = new APIListResponse<>(optionalVehicleDTOS);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OptionalVehicleDTO> findById(@PathVariable Long id) {
        var optionalVehicleModel = this.optionalVehicleService.getByIdOptionalVehicleFind(id);
        var optionalVehicleDTO = this.optionalVehicleMapper.entityToDTO(optionalVehicleModel);

        return new ResponseEntity<>(optionalVehicleDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<OptionalVehicle> save(@RequestBody OptionalVehicle optionalVehicle) {
        return new ResponseEntity<>(this.optionalVehicleService.save(optionalVehicle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<OptionalVehicle> updateById(@PathVariable Long id, @RequestBody OptionalVehicle optionalVehicle) {
        return new ResponseEntity<>(this.optionalVehicleService.updateById(id, optionalVehicle), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        this.optionalVehicleService.deleteById(id);
    }
}
