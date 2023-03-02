package com.p360server.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String student_name;
    private Number student_rollno;
    private Number student_cgpa;
    private Number student_marks_array;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Number getStudent_rollno() {
        return student_rollno;
    }

    public void setStudent_rollno(Number student_rollno) {
        this.student_rollno = student_rollno;
    }

    public Number getStudent_cgpa() {
        return student_cgpa;
    }

    public void setStudent_cgpa(Number student_cgpa) {
        this.student_cgpa = student_cgpa;
    }

    public Number getStudent_marks_array() {
        return student_marks_array;
    }

    public void setStudent_marks_array(Number student_marks_array) {
        this.student_marks_array = student_marks_array;
    }
}
