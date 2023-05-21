package com.es.lepelka.model;

import jakarta.persistence.*;

@Entity(name = "Topic")
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String section;

    private String subsection;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;

    public Topic() {

    }

    public Topic(String name, String section, String subsection) {
        this.name = name;
        this.section = section;
        this.subsection = subsection;
    }

    public Topic(String name, String section, String subsection, byte[] data) {
        this.name = name;
        this.section = section;
        this.subsection = subsection;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
