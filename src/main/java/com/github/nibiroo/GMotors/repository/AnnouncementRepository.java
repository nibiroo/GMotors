package com.github.nibiroo.GMotors.repository;

import com.github.nibiroo.GMotors.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Query(value = "SELECT * FROM announcement WHERE KM > 0.0", nativeQuery = true)
    List<Announcement> findAllByKmThanZero();

    @Query(value = "SELECT * FROM announcement WHERE KM = 0.0", nativeQuery = true)
    List<Announcement> findAllThanZero();

    @Query(value = "SELECT * FROM announcement WHERE KM >= ?1 AND KM <= ?2", nativeQuery = true)
    List<Announcement> findAllThanKmInRangeKm(Float smallerKm, Float biggerKm);

    @Query(value = "SELECT * FROM announcement WHERE PRICE >= ?1 AND PRICE <= ?2", nativeQuery = true)
    List<Announcement> findAllThanPriceInRangePrice(Float smallerPrice, Float biggerPrice);
}
