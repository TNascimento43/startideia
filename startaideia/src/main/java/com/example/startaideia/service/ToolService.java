package com.example.startaideia.service;

import com.example.startaideia.mapper.ToolMapper;
import com.example.startaideia.model.dto.ToolDTO;
import com.example.startaideia.model.entity.Tag;
import com.example.startaideia.model.entity.Tool;
import com.example.startaideia.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ToolService {

    private final TagService tagService;
    private final ToolRepository repository;
    private final ToolMapper mapper;

    public List<ToolDTO> getToolsByTag(String tag) {
        if (StringUtils.isBlank(tag)) {
            return repository.findAll().stream().map(this::extractTagDescription).collect(Collectors.toList());
        }
        List<Tag> tags = tagService.getToolsByTag(tag);
        return tags.stream().map(it -> extractTagDescription(it.getTool())).collect(Collectors.toList());
    }

    @Transactional
    public ToolDTO save(ToolDTO dto) {
        Tool tool = mapper.toEntity(dto);
        tool.setTagList(Collections.emptyList());
        List<Tag> tags = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dto.getTags())) {
            dto.getTags().forEach(descriptionTag -> {
                Tag tag = new Tag();
                tag.setTool(tool);
                tag.setDescription(descriptionTag);
                tags.add(tag);
            });
            tool.setTagList(tags);
        }
        return extractTagDescription(repository.save(tool));
    }

    @Transactional
    public void delete(Long id) {
        Tool tool = repository.findById(id).orElse(null);
        if (tool == null) {
            throw new RuntimeException("Ferramenta não foi encontrada");
        }
        repository.deleteById(id);
    }

    private ToolDTO extractTagDescription(Tool tool) {
        ToolDTO dto = mapper.toDto(tool);
        dto.setTags(tool.getTagList().stream().map(Tag::getDescription).collect(Collectors.toList()));
        return dto;
    }
}
