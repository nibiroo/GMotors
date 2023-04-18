package com.github.nibiroo.GMotors.controller;

import com.github.nibiroo.GMotors.dto.AnnouncementDTO;
import com.github.nibiroo.GMotors.entity.APIListResponse;
import com.github.nibiroo.GMotors.entity.Announcement;
import com.github.nibiroo.GMotors.mapper.AnnouncementMapper;
import com.github.nibiroo.GMotors.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcement/")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;

    @GetMapping
    public ResponseEntity<APIListResponse<AnnouncementDTO>> findAll() {
        var carMakerDTOS = this.announcementService.getAllAnnouncementFind()
                .stream()
                .map(this.announcementMapper::entityToDTO)
                .collect(Collectors.toList());
        var response = new APIListResponse<>(carMakerDTOS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnnouncementDTO> findById(@PathVariable Long id) {
        var announcementModel = this.announcementService.getByIdAnnouncementFind(id);
        var announcementDTO = this.announcementMapper.entityToDTO(announcementModel);

        return new ResponseEntity<>(announcementDTO, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Announcement> save(@RequestBody Announcement announcement) {
        return new ResponseEntity<>(this.announcementService.save(announcement), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Announcement> update(@PathVariable Long id, @RequestBody Announcement carMaker) {
        return new ResponseEntity<>(this.announcementService.updateById(id, carMaker), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.announcementService.deleteById(id);
    }
}
