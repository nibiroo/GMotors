package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.OptionalVehicle;
import com.github.nibiroo.GMotors.repository.OptionalVehicleRepository;
import com.github.nibiroo.GMotors.service.OptionalVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OptionalVehicleServiceImpl implements OptionalVehicleService {
    private OptionalVehicleRepository optionalVehicleRepository;

    @Autowired
    public OptionalVehicleServiceImpl(OptionalVehicleRepository optionalVehicleRepository) {
        this.optionalVehicleRepository = optionalVehicleRepository;
    }

    @Override
    public List<OptionalVehicle> getAllOptionalVehicleFind() {
        return this.optionalVehicleRepository.findAll();
    }

    @Override
    public OptionalVehicle getByIdOptionalVehicleFind(Long id) {
        return this.optionalVehicleRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));
    }

    @Override
    public OptionalVehicle save(OptionalVehicle optionalVehicle) {
        return this.optionalVehicleRepository.save(optionalVehicle);
    }

    @Override
    public OptionalVehicle updateById(Long id, OptionalVehicle optionalVehicle) {
        var optVehicleExist = this.optionalVehicleRepository.findById(id).map(it -> {
            optionalVehicle.setId(it.getId());
            this.optionalVehicleRepository.save(optionalVehicle);
            return it;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));

        return optVehicleExist;
    }

    @Override
    public void deleteById(Long id) {
        this.optionalVehicleRepository.deleteById(id);
    }
}
