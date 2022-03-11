package com.example.startaideia.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ToolDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String link;
    private String title;
    private String description;
    private List<String> tags;
}
