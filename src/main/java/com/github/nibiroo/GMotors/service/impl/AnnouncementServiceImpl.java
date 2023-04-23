package com.github.nibiroo.GMotors.service.impl;

import com.github.nibiroo.GMotors.entity.Announcement;
import com.github.nibiroo.GMotors.repository.AnnouncementRepository;
import com.github.nibiroo.GMotors.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> findAllAnnouncement() {
        return this.announcementRepository.findAll();
    }

    @Override
    public Announcement getByIdAnnouncement(Long id) {
        return this.announcementRepository.findById(id)
                                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Announcement with id " + id));
    }

    @Override
    public List<Announcement> findAllAnnouncementsWithVehiclesUseds() {
        return this.announcementRepository.findAllByKmThanZero();
    }

    @Override
    public List<Announcement> findAllAnnouncementsWithVehiclesNews() {
        return this.announcementRepository.findAllThanZero();
    }

    @Override
    public List<Announcement> findAllAnnouncementsWithVehiclesWithRangeKm(Float smallerKm, Float biggerKm) {
        return this.announcementRepository.findAllThanKmInRangeKm(smallerKm, biggerKm);
    }

    @Override
    public List<Announcement> findAllAnnouncementsWithVehiclesWithRangePrice(Float smallerPrice, Float biggerPrice) {
        return this.announcementRepository.findAllThanPriceInRangePrice(smallerPrice, biggerPrice);
    }

    @Override
    public Announcement save(Announcement announcement) {
        return this.announcementRepository.save(announcement);
    }

    @Override
    public Announcement updateById(Long id, Announcement announcement) {
        var announcementExist = this.announcementRepository.findById(id).map(it -> {
            announcement.setId(it.getId());
            this.announcementRepository.save(announcement);
            return it;
        }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't Announcement with id " + id));

        return announcementExist;
    }

    @Override
    public void deleteById(Long id) {
        this.announcementRepository.deleteById(id);
    }
}
