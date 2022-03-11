package com.example.startaideia.service;

import com.example.startaideia.model.entity.Tag;
import com.example.startaideia.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository repository;

    public List<Tag> getToolsByTag(String description) {
        return repository.findAllByDescription(description);
    }
}
