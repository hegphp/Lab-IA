/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "primaryKey.score", cascade = CascadeType.ALL)
    private Set<Grade_Score> grade_Scores = new HashSet<>();

    public Score() {
    }

    public Set<Grade_Score> getGrade_Scores() {
        return grade_Scores;
    }

    public void setGrade_Scores(Set<Grade_Score> grade_Scores) {
        this.grade_Scores = grade_Scores;
    }

    public Score(String scoreId, String scoreName) {
        this.scoreId = scoreId;
        this.scoreName = scoreName;
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
}
