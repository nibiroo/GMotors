package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionalService {
    List<Optional> findAllOptionalVehicle();

    Optional getByIdOptionalVehicle(Long id);

    Optional save(Optional optional);

    Optional updateById(Long id, Optional optional);

    void deleteById(Long id);
}
