package com.example.erp.bean;

import javax.persistence.*;

@Entity
public class Course_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    int course_id;

    String course_name;

    int time;

    String day;

    public Course_Schedule() {
    }

    public Course_Schedule(int id, int course_id, String course_name, int time, String day) {
        this.id = id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.time = time;
        this.day = day;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
