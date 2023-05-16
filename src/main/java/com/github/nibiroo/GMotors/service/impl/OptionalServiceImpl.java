package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.Optional;
import com.github.nibiroo.GMotors.repository.OptionalRepository;
import com.github.nibiroo.GMotors.service.OptionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OptionalServiceImpl implements OptionalService {
    private final OptionalRepository optionalRepository;

    @Autowired
    public OptionalServiceImpl(OptionalRepository optionalRepository) {
        this.optionalRepository = optionalRepository;
    }

    @Override
    public List<Optional> findAllOptionalVehicle(int page, int recordCount) {
        Pageable pageable = PageRequest.of(page, recordCount);
        return this.optionalRepository.findAll(pageable).get().toList();
    }

    @Override
    public Optional getByIdOptionalVehicle(Long id) {
        return this.optionalRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));
    }

    @Override
    public Optional save(Optional optional) {
        return this.optionalRepository.save(optional);
    }

    @Override
    public Optional updateById(Long id, Optional optional) {
        var optVehicleExist = this.optionalRepository.findById(id).map(it -> {
            optional.setId(it.getId());
            this.optionalRepository.save(optional);
            return it;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Optional Vehicle with id " + id));

        return optVehicleExist;
    }

    @Override
    public void deleteById(Long id) {
        this.optionalRepository.deleteById(id);
    }
}
