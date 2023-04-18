package com.github.nibiroo.GMotors.service;

import com.github.nibiroo.GMotors.entity.Announcement;
import com.github.nibiroo.GMotors.entity.CarMaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnouncementService {
    List<Announcement> getAllAnnouncementFind();

    Announcement getByIdAnnouncementFind(Long id);

    Announcement save(Announcement announcement);

    Announcement updateById(Long id, Announcement announcement);

    void deleteById(Long id);
}
