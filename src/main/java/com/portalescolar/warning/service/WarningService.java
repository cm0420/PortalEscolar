package com.portalescolar.warning.service;

import com.portalescolar.warning.dto.WarningRequestDto;
import com.portalescolar.warning.dto.WarningResponseDto;
import com.portalescolar.warning.entity.Priority;
import com.portalescolar.warning.entity.Warning;
import com.portalescolar.warning.mapper.WarningMapper;
import com.portalescolar.warning.repository.WarningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class WarningService {
    private final WarningRepository warningRepository;
    private final WarningMapper mapper;

    public WarningResponseDto save(WarningRequestDto requestDto){
        Warning warning= mapper.toEntity(requestDto);
        Warning savedWarning= warningRepository.save(warning);
        return mapper.toResponseDto(savedWarning);
    }

    public Page<WarningResponseDto> findbyPriority(Priority priority, Pageable pageable){
        return warningRepository.findAllByActiveTrueAndPriority(priority, pageable).map(mapper::toResponseDto);
    }
}
