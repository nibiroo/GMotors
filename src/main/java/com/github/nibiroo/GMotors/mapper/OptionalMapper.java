package com.github.nibiroo.GMotors.mapper;

import com.github.nibiroo.GMotors.dto.optional.OptionalCreateDTO;
import com.github.nibiroo.GMotors.dto.optional.OptionalResponseDTO;
import com.github.nibiroo.GMotors.dto.optional.OptionalUpdateDTO;
import com.github.nibiroo.GMotors.entity.Optional;
import org.springframework.stereotype.Service;

@Service
public class OptionalMapper {
    public OptionalResponseDTO modalToResponseDto(Optional optional) {
        var dto = new OptionalResponseDTO();
        dto.setId(optional.getId());
        dto.setShortDescription(optional.getShortDescription());
        return dto;
    }
    public Optional responseDtoToModal(OptionalResponseDTO optionalResponseDTO) {
        var modal = new Optional();
        modal.setId(optionalResponseDTO.getId());
        modal.setShortDescription(optionalResponseDTO.getShortDescription());
        return modal;
    }

    public OptionalCreateDTO modalToCreateDto(Optional optional) {
        var dto = new OptionalCreateDTO();
        dto.setShortDescription(optional.getShortDescription());
        return dto;
    }
    public Optional createDtoToModal(OptionalCreateDTO optionalCreateDTO) {
        var modal = new Optional();
        modal.setShortDescription(optionalCreateDTO.getShortDescription());
        return modal;
    }

    public OptionalUpdateDTO modalToUpdateDto(Optional optional) {
        var dto = new OptionalUpdateDTO();
        dto.setId(optional.getId());
        dto.setShortDescription(optional.getShortDescription());
        return dto;
    }
    public Optional updateDtoToModal(OptionalUpdateDTO optionalUpdateDTO) {
        var modal = new Optional();
        modal.setId(optionalUpdateDTO.getId());
        modal.setShortDescription(optionalUpdateDTO.getShortDescription());
        return modal;
    }
}
