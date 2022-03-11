package com.example.startaideia.controller;

import com.example.startaideia.model.dto.ToolDTO;
import com.example.startaideia.service.ToolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/tools")
public class ToolController {

    private final ToolService service;

    @GetMapping
    public ResponseEntity<List<ToolDTO>> getToolsByTag(@RequestParam(value = "tag", required = false) String tag) {
        log.info("REST to get all Tools by Tag: {}", tag);
        return ResponseEntity.ok(service.getToolsByTag(tag));
    }

    @PostMapping
    public ResponseEntity<ToolDTO> save(@RequestBody ToolDTO dto) {
        log.info("REST to save Tool");
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("id") Long id) {
        log.info("REST to delete Tool by id: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
