package com.p360server.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Roadmap {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String roadmap_topic;
    private String roadmap_subtopic;
    private String roadmap_description;
    private String roadmap_youtube;


    public String getRoadmap_topic() {
        return roadmap_topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoadmap_topic(String roadmap_topic) {
        this.roadmap_topic = roadmap_topic;
    }

    public String getRoadmap_subtopic() {
        return roadmap_subtopic;
    }

    public void setRoadmap_subtopic(String roadmap_subtopic) {
        this.roadmap_subtopic = roadmap_subtopic;
    }

    public String getRoadmap_description() {
        return roadmap_description;
    }

    public void setRoadmap_description(String roadmap_description) {
        this.roadmap_description = roadmap_description;
    }

    public String getRoadmap_youtube() {
        return roadmap_youtube;
    }

    public void setRoadmap_youtube(String roadmap_youtube) {
        this.roadmap_youtube = roadmap_youtube;
    }
}
