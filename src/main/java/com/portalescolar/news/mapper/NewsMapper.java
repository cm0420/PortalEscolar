package com.portalescolar.news.mapper;

import com.portalescolar.news.dto.NewsRequestDto;
import com.portalescolar.news.dto.NewsResponseDto;
import com.portalescolar.news.entity.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    News toEntity(NewsRequestDto dto);

    NewsResponseDto toResponseDto(News entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromDto(NewsRequestDto dto, @MappingTarget News entity);

}
