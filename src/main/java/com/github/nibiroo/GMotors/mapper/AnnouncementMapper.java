package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.announcement.AnnouncementCreateDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementResponseDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementUpdateDto;
import com.github.nibiroo.GMotors.entity.Announcement;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementMapper {
    public AnnouncementResponseDto modalToResponseDto(Announcement announcement) {
        var dto = new AnnouncementResponseDto();
        dto.setId(announcement.getId());
        dto.setVehicle(announcement.getVehicle());
        dto.setKm(announcement.getKm());
        dto.setCity(announcement.getCity());
        dto.setPrice(announcement.getPrice());
        return dto;
    }
    public Announcement responseDtoToModal(AnnouncementResponseDto announcementResponseDto) {
        var modal = new Announcement();
        modal.setId(announcementResponseDto.getId());
        modal.setVehicle(announcementResponseDto.getVehicle());
        modal.setKm(announcementResponseDto.getKm());
        modal.setCity(announcementResponseDto.getCity());
        modal.setPrice(announcementResponseDto.getPrice());
        return modal;
    }

    public AnnouncementCreateDto modalToCreateDto(Announcement announcement) {
        var dto = new AnnouncementCreateDto();
        dto.setVehicle(announcement.getVehicle());
        dto.setKm(announcement.getKm());
        dto.setCity(announcement.getCity());
        dto.setPrice(announcement.getPrice());
        return dto;
    }
    public Announcement createDtoToModal(AnnouncementCreateDto announcementCreateDto) {
        var modal = new Announcement();
        modal.setVehicle(announcementCreateDto.getVehicle());
        modal.setKm(announcementCreateDto.getKm());
        modal.setCity(announcementCreateDto.getCity());
        modal.setPrice(announcementCreateDto.getPrice());
        return modal;
    }

    public AnnouncementUpdateDto modalToUpdateDto(Announcement announcement) {
        var dto = new AnnouncementUpdateDto();
        dto.setVehicle(announcement.getVehicle());
        dto.setKm(announcement.getKm());
        dto.setCity(announcement.getCity());
        dto.setPrice(announcement.getPrice());
        return dto;
    }
    public Announcement updateDtoToModal(AnnouncementUpdateDto announcementUpdateDto) {
        var modal = new Announcement();
        modal.setVehicle(announcementUpdateDto.getVehicle());
        modal.setKm(announcementUpdateDto.getKm());
        modal.setCity(announcementUpdateDto.getCity());
        modal.setPrice(announcementUpdateDto.getPrice());
        return modal;
    }
}
