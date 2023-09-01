/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hegphp
 */
@Entity
@Table(name = "Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterId;
    @Column(name = "`from`")
    private Date from;
    @Column(name = "`to`")
    private Date to;
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "semester")
    Set<Course> courseList = new HashSet();
    
    @OneToMany(mappedBy = "semester")
    Set<Grade> GradeList = new HashSet<>();

    public Semester() {
    }

    public Semester(Date from, Date to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Set<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Set<Course> courseList) {
        this.courseList = courseList;
    }

    public Set<Grade> getGradeList() {
        return GradeList;
    }

    public void setGradeList(Set<Grade> GradeList) {
        this.GradeList = GradeList;
    }
    
}