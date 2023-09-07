/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name = "gradeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @OneToMany(mappedBy = "primaryKey.grade", cascade = CascadeType.ALL)
    private Set<Grade_Score> grade_Scores = new HashSet<>();

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<Grade_Score> getGrade_Scores() {
        return grade_Scores;
    }

    public void setGrade_Scores(Set<Grade_Score> grade_Scores) {
        this.grade_Scores = grade_Scores;
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

    public Grade(Student student, Semester semester, Course course, boolean gradeStatus) {
        this.student = student;
        this.semester = semester;
        this.course = course;
        this.gradeStatus = gradeStatus;
    }

    @Column(name = "Status")
    private boolean gradeStatus;
}
