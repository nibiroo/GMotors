package com.github.nibiroo.GMotors.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarMakerDTO {
    private Long id;

    private String name;

    private String nativeCountry;
}
