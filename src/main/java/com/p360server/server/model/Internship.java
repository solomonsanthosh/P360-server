package com.p360server.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String internship_name;
    private String inernship_description;
    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternship_name() {
        return internship_name;
    }

    public void setInternship_name(String internship_name) {
        this.internship_name = internship_name;
    }

    public String getInernship_description() {
        return inernship_description;
    }

    public void setInernship_description(String inernship_description) {
        this.inernship_description = inernship_description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
