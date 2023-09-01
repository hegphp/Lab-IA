/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Subject")
public class Subject {
    @Id
    @Column(name = "SubjectId")
    private String subjectId;
    @Column(name="Name")
    private String subjectName;
    @ManyToOne
    @JoinColumn(name = "subjectType")
    private SubjectType subjectType;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    Set<Course> CourseId = new HashSet<>();

    public Subject(String subjectId, String subjectName, SubjectType subjectType, int credits, float fee, float feeInter) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
        this.credits = credits;
        this.fee = fee;
        this.feeInter = feeInter;
    }

    public Subject() {
    }
    @Column(name = "Credits")
    private int credits;
    @Column(name = "fee")
    private float fee;
    @Column(name="feeInter")
    private float feeInter;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Set<Course> getCourseId() {
        return CourseId;
    }

    public void setCourseId(Set<Course> CourseId) {
        this.CourseId = CourseId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getFeeInter() {
        return feeInter;
    }

    public void setFeeInter(float feeInter) {
        this.feeInter = feeInter;
    }

    
}
