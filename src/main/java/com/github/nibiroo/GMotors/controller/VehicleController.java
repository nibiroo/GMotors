package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.vehicle.VehicleCreateDTO;
import com.github.nibiroo.GMotors.dto.vehicle.VehicleResponseDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.entity.Vehicle;
import com.github.nibiroo.GMotors.mapper.VehicleMapper;
import com.github.nibiroo.GMotors.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping(value = {"","/"})
    public ResponseEntity<APIListResponse<VehicleResponseDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                       @RequestParam(value = "limit", defaultValue = "50") int limit) {
        var vehicleDTOS = this.vehicleService.findAllVehicle(page, limit)
                .stream()
                .map(this.vehicleMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(vehicleDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable Long id) {
        var vehicleModel = this.vehicleService.getByIVehicle(id);
        var vehicleDTO = this.vehicleMapper.modalToResponseDto(vehicleModel);

        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<VehicleCreateDTO> save(@RequestBody VehicleCreateDTO vehicleCreateDTO) {
        var model = vehicleMapper.createDtoToModal(vehicleCreateDTO);
        var dto = vehicleMapper.modalToCreateDto(this.vehicleService.save(model));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(this.vehicleService.updateById(id, vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.vehicleService.deleteById(id);
    }
}
