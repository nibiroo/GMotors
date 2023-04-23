package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Announcement;
import com.github.nibiroo.GMotors.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnouncementService {
    List<Announcement> findAllAnnouncement();

    Announcement getByIdAnnouncement(Long id);

    List<Announcement> findAllAnnouncementWithVehiclesUseds();

    Announcement save(Announcement announcement);

    Announcement updateById(Long id, Announcement announcement);

    void deleteById(Long id);

}
