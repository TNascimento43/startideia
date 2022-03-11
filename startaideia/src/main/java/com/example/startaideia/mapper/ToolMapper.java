package com.example.startaideia.mapper;

import com.example.startaideia.model.dto.ToolDTO;
import com.example.startaideia.model.entity.Tool;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToolMapper {

    ToolDTO toDto(Tool entity);

    Tool toEntity(ToolDTO dto);
}
