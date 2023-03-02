package com.p360server.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competitive {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competitive_topic;
    private Number student_rollno;
    private Number competitive_percentage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetitive_topic() {
        return competitive_topic;
    }

    public void setCompetitive_topic(String competitive_topic) {
        this.competitive_topic = competitive_topic;
    }

    public Number getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(Number student_rollno) {
        this.student_rollno = student_rollno;
    }

    public Number getCompetitive_percentage() {
        return competitive_percentage;
    }

    public void setCompetitive_percentage(Number competitive_percentage) {
        this.competitive_percentage = competitive_percentage;
    }
}
