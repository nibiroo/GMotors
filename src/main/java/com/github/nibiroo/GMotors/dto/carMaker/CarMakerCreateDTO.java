package com.github.nibiroo.GMotors.dto.carMaker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarMakerCreateDTO {
    private String name;

    private String nativeCountry;
}
