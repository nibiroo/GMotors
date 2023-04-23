package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Announcement;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface AnnouncementService {
    List<Announcement> findAllAnnouncement();

    Announcement getByIdAnnouncement(Long id);

    List<Announcement> findAllAnnouncementsWithVehiclesUseds();

    List<Announcement> findAllAnnouncementsWithVehiclesNews();

    List<Announcement> findAllAnnouncementsWithVehiclesWithRangeKm(Float smallerKm, Float biggerKm);

    List<Announcement> findAllAnnouncementsWithVehiclesWithRangePrice(Float smallerPrice, Float biggerPrice);

    Announcement save(Announcement announcement);

    Announcement updateById(Long id, Announcement announcement);

    void deleteById(Long id);

}
