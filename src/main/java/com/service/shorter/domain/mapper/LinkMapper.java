package com.service.shorter.domain.mapper;

import com.service.shorter.domain.Link;
import com.service.shorter.domain.dto.LinkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface LinkMapper  {
    LinkMapper INSTANCE = Mappers.getMapper(LinkMapper.class);

    LinkDTO toDTO(Link link);
    Link toEntity(LinkDTO linkDTO);

}
