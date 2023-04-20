package com.github.nibiroo.GMotors.repository;

import com.github.nibiroo.GMotors.entity.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionalVehicleRepository extends JpaRepository<Optional, Long> {
}
