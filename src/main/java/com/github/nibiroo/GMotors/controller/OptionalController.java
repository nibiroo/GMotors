package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.optional.OptionalCreateDTO;
import com.github.nibiroo.GMotors.dto.optional.OptionalResponseDTO;
import com.github.nibiroo.GMotors.dto.optional.OptionalUpdateDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.mapper.OptionalMapper;
import com.github.nibiroo.GMotors.service.OptionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/optionals")
public class OptionalController {
    private final OptionalService optionalService;
    private final OptionalMapper optionalMapper;

    @Autowired
    public OptionalController(OptionalService optionalService, OptionalMapper optionalMapper) {
        this.optionalService = optionalService;
        this.optionalMapper = optionalMapper;
    }

    @GetMapping(value = {"","/"})
    public ResponseEntity<APIListResponse<OptionalResponseDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                        @RequestParam(value = "limit", defaultValue = "50") int limit) {
        var optionalVehicleDTOS = this.optionalService.findAllOptionalVehicle(page, limit)
                                                                .stream()
                                                                .map(this.optionalMapper::modalToResponseDto)
                                                                .collect(Collectors.toList());
        var response = new APIListResponse<>(optionalVehicleDTOS);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionalResponseDTO> findById(@PathVariable Long id) {
        var optionalVehicleModel = this.optionalService.getByIdOptionalVehicle(id);
        var optionalVehicleDTO = this.optionalMapper.modalToResponseDto(optionalVehicleModel);

        return new ResponseEntity<>(optionalVehicleDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<OptionalCreateDTO> save(@RequestBody OptionalCreateDTO optionalCreateDTO) {
        var model = optionalMapper.createDtoToModal(optionalCreateDTO);
        var dto = optionalMapper.modalToCreateDto(this.optionalService.save(model));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionalUpdateDTO> updateById(@PathVariable Long id, @RequestBody OptionalUpdateDTO optionalUpdateDTO) {
        var model = optionalMapper.updateDtoToModal(optionalUpdateDTO);
        var dto = optionalMapper.modalToUpdateDto(this.optionalService.updateById(id, model));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        this.optionalService.deleteById(id);
    }
}
