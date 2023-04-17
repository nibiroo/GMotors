package com.github.nibiroo.GMotors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class APIListResponse<T> {
    private List<T> content;
}
