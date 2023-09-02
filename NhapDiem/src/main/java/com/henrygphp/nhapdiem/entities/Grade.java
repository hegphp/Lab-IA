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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hegphp
 */
@Entity
@Table(name = "Grade")
public class Grade {

    @Id
    @Column(name = "GradeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;

    @ManyToOne
    @JoinColumn(name = "StudentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "SemesterId")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "CourseId")
    private Course course;

    @ManyToMany
    @JoinTable(name = "Grade_Score", joinColumns = {
        @JoinColumn(name = "gradeId")}, inverseJoinColumns = {
        @JoinColumn(name = "scoreId")})
    private Set<Score> scoreList = new HashSet<>();

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(Set<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public Grade() {
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course courseId) {
        this.course = courseId;
    }

    public boolean isGradeStatus() {
        return gradeStatus;
    }

    public void setGradeStatus(boolean gradeStatus) {
        this.gradeStatus = gradeStatus;
    }

    public Grade(Student student, Semester semester, Course courseId, boolean gradeStatus) {
        this.student = student;
        this.semester = semester;
        this.course = courseId;
        this.gradeStatus = gradeStatus;
    }

    @Column(name = "Status")
    private boolean gradeStatus;
}
