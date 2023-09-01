/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hegphp
 */
@Entity
@Table(name = "Score")
public class Score {
    @Id
    @Column(name = "scoreId")
    private String scoreId;
    
    private String scoreName;
    private float Score;
    private float weight;
    
    @ManyToMany
    @JoinTable(name = "Grade_Score", joinColumns = {@JoinColumn(name = "scoreId")}, inverseJoinColumns = {@JoinColumn(name = "gradeId")})
    private Set<Grade> gradeList = new HashSet<>();

    public Score() {
    }

    public Score(String scoreId, String scoreName, float Score, float weight) {
        this.scoreId = scoreId;
        this.scoreName = scoreName;
        this.Score = Score;
        this.weight = weight;
    }

    public String getScoreId() {
        return scoreId;
    }

    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public float getScore() {
        return Score;
    }

    public void setScore(float Score) {
        this.Score = Score;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Set<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(Set<Grade> gradeList) {
        this.gradeList = gradeList;
    }
    
}
