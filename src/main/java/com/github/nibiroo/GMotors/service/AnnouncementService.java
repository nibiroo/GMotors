package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Announcement;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AnnouncementService {
    List<Announcement> findAllAnnouncement();

    Announcement getByIdAnnouncement(Long id);

    List<Announcement> findAllAnnouncementsWithVehiclesUseds();

    List<Announcement> findAllAnnouncementsWithVehiclesNews();

    List<Announcement> findAllAnnouncementsWithVehiclesWithRangeKm(BigDecimal smallerKm, BigDecimal biggerKm);

    List<Announcement> findAllAnnouncementsWithVehiclesWithRangePrice(BigDecimal smallerPrice, BigDecimal biggerPrice);

    Announcement save(Announcement announcement);

    Announcement updateById(Long id, Announcement announcement);

    void deleteById(Long id);

}
