package com.github.nibiroo.GMotors.dto.announcement;

import com.github.nibiroo.GMotors.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementCreateDto {
    private Vehicle vehicle;

    private BigDecimal price;

    private BigDecimal km;

    private String city;
}
