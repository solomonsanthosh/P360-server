package com.p360server.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String project_name;
    private Number student_rollno;
    private String project_description;
    private Number project_score;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Number getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(Number student_rollno) {
        this.student_rollno = student_rollno;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public Number getProject_score() {
        return project_score;
    }

    public void setProject_score(Number project_score) {
        this.project_score = project_score;
    }
}
