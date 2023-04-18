package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.CarMakerDTO;
import com.github.nibiroo.GMotors.dto.VehicleDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.entity.CarMaker;
import com.github.nibiroo.GMotors.entity.Vehicle;
import com.github.nibiroo.GMotors.mapper.CarMakerMapper;
import com.github.nibiroo.GMotors.mapper.VehicleMapper;
import com.github.nibiroo.GMotors.service.CarMakerService;
import com.github.nibiroo.GMotors.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping()
    public ResponseEntity<APIListResponse<VehicleDTO>> findAll() {
        var vehicleDTOS = this.vehicleService.getAllVehicleFind()
                .stream()
                .map(this.vehicleMapper::entityToDTO)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(vehicleDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable Long id) {
        var vehicleModel = this.vehicleService.getByIVehicleFind(id);
        var vehicleDTO = this.vehicleMapper.entityToDTO(vehicleModel);

        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(this.vehicleService.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(this.vehicleService.updateById(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.vehicleService.deleteById(id);
    }
}
