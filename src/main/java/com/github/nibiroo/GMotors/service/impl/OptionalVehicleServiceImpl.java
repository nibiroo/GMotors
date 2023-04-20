package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.Optional;
import com.github.nibiroo.GMotors.repository.OptionalVehicleRepository;
import com.github.nibiroo.GMotors.service.OptionalVehicleService;
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
    public List<Optional> getAllOptionalVehicleFind() {
        return this.optionalVehicleRepository.findAll();
    }

    @Override
    public Optional getByIdOptionalVehicleFind(Long id) {
        return this.optionalVehicleRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));
    }

    @Override
    public Optional save(Optional optional) {
        return this.optionalVehicleRepository.save(optional);
    }

    @Override
    public Optional updateById(Long id, Optional optional) {
        var optVehicleExist = this.optionalVehicleRepository.findById(id).map(it -> {
            optional.setId(it.getId());
            this.optionalVehicleRepository.save(optional);
            return it;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));

        return optVehicleExist;
    }

    @Override
    public void deleteById(Long id) {
        this.optionalVehicleRepository.deleteById(id);
    }
}
