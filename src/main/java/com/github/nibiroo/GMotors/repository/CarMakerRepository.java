package com.github.nibiroo.GMotors.repository;

import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMakerRepository extends JpaRepository<CarMaker, Long> {
}
