package com.github.nibiroo.GMotors.dto.announcement;

import com.github.nibiroo.GMotors.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementUpdateDto {
    private Long id;

    private Vehicle vehicle;

    private float price;

    private Float km;

    private String city;
}
