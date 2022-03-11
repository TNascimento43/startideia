package com.example.startaideia.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "tb_tool")
public class Tool implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SEQ_TOOL = "seq_tool";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_TOOL)
    @SequenceGenerator(name = SEQ_TOOL, sequenceName = SEQ_TOOL, allocationSize = 1)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="tool", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tagList;

}
