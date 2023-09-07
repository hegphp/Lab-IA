/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.nhapdiem.entities;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 *
 * @author Hegphp
 */
@Entity
@Table(name="Grade_Score")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.grade",
        joinColumns = @JoinColumn(name = "gradeId")),
    @AssociationOverride(name="primaryKey.score",
        joinColumns = @JoinColumn(name = "scoreId")) })
public class Grade_Score {
    //composite-id key
    @EmbeddedId
    private GradeScoreId primaryKey = new GradeScoreId();
    
    //additional fields
    private float number;
    private float weight;
    
    @Transient
    public Grade getGrade(){
        return getPrimaryKey().getGrade();
    }
    
    public void setGrade(Grade grade){
        getPrimaryKey().setGrade(grade);
    }
    
    @Transient
    public Score getScore(){
        return getPrimaryKey().getScore();
    }
    
    public void setScore(Score score){
        getPrimaryKey().setScore(score);
    }

    public GradeScoreId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(GradeScoreId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }
}
