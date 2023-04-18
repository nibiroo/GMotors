package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.AnnouncementDTO;
import com.github.nibiroo.GMotors.entity.Announcement;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementMapper {
    public AnnouncementDTO entityToDTO(Announcement announcement) {
        var dto = new AnnouncementDTO();
        dto.setId(announcement.getId());
        dto.setVehicle(announcement.getVehicle());
        dto.setPrice(announcement.getPrice());
        dto.setKm(announcement.getKm());
        dto.setCity(announcement.getCity());
        return dto;
    }
}
