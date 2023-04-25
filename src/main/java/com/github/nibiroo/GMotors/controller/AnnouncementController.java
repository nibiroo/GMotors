package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.announcement.AnnouncementCreateDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementResponseDto;
import com.github.nibiroo.GMotors.dto.announcement.AnnouncementUpdateDto;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.mapper.AnnouncementMapper;
import com.github.nibiroo.GMotors.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcements/")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;

    @GetMapping
    public ResponseEntity<APIListResponse<AnnouncementResponseDto>> findAll() {
        var carMakerDTOS = this.announcementService.findAllAnnouncement()
                .stream()
                .map(this.announcementMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(carMakerDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnnouncementResponseDto> findById(@PathVariable Long id) {
        var announcementModel = this.announcementService.getByIdAnnouncement(id);
        var announcementDTO = this.announcementMapper.modalToResponseDto(announcementModel);

        return new ResponseEntity<>(announcementDTO, HttpStatus.OK);
    }

    @GetMapping("useds/")
    public ResponseEntity<APIListResponse<AnnouncementResponseDto>> findAllAnnouncementsWithVehiclesUseds() {
        var announcementResponseDtos = this.announcementService.findAllAnnouncementsWithVehiclesUseds()
                .stream()
                .map(this.announcementMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(announcementResponseDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("news/")
    public ResponseEntity<APIListResponse<AnnouncementResponseDto>> findAllAnnouncementsWithVehiclesNews() {
        var announcementResponseDtos = this.announcementService.findAllAnnouncementsWithVehiclesNews()
                .stream()
                .map(this.announcementMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(announcementResponseDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("rangekm/{smaller}/{bigger}")
    public ResponseEntity<APIListResponse<AnnouncementResponseDto>> findAllAnnouncementsWithVehiclesRangeKm(@PathVariable("smaller") BigDecimal smallerKm, @PathVariable("bigger") BigDecimal biggerKm) {
        var announcementResponseDtos = this.announcementService.findAllAnnouncementsWithVehiclesWithRangeKm(smallerKm, biggerKm)
                .stream()
                .map(this.announcementMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(announcementResponseDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("rangeprice/{smaller}/{bigger}")
    public ResponseEntity<APIListResponse<AnnouncementResponseDto>> findAllAnnouncementsWithVehiclesRangePrice(@PathVariable("smaller") BigDecimal smallerPrice, @PathVariable("bigger") BigDecimal biggerPrice) {
        var announcementResponseDtos = this.announcementService.findAllAnnouncementsWithVehiclesWithRangePrice(smallerPrice, biggerPrice)
                .stream()
                .map(this.announcementMapper::modalToResponseDto)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(announcementResponseDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<AnnouncementCreateDto> save(@RequestBody AnnouncementCreateDto announcementCreateDto) {
        var model = announcementMapper.createDtoToModal(announcementCreateDto);
        var dto = announcementMapper.modalToCreateDto(this.announcementService.save(model));
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AnnouncementUpdateDto> update(@PathVariable Long id, @RequestBody AnnouncementUpdateDto announcementUpdateDto) {
        var model = announcementMapper.updateDtoToModal(announcementUpdateDto);
        var dto = announcementMapper.modalToUpdateDto(this.announcementService.updateById(id, model));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.announcementService.deleteById(id);
    }
}
