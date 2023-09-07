/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.henrygphp.NhapDiem.utils;

import com.henrygphp.nhapdiem.entities.Course;
import com.henrygphp.nhapdiem.entities.Grade;
import com.henrygphp.nhapdiem.entities.Score;
import com.henrygphp.nhapdiem.entities.Semester;
import com.henrygphp.nhapdiem.entities.Student;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author Hegphp
 */
public class GradeManager {

    public void showInformation() {
        //Choose semester
        displaySemester();
        Scanner sc = new Scanner(System.in);
        System.out.print("Type Semester Id: ");
        //Get Semester by user's selection
        Semester semester = getSemesterById(Integer.parseInt(sc.nextLine()));
        //Display Course by Semester
        displayCourseBySemester(semester);
        System.out.print("Type course name: ");
        //Get Course by User's selection
        Course course = getCourseByName(sc.nextLine());
        //display Student list
        displayStudentListByCourse(course);
        System.out.print("Type studentId: ");
        //get Student Grade by Choice
        Grade grade = getStudentGradeByStudentId(sc.nextLine());
        //display student grade
        displayStudentGrade(grade);
    }

    public void updateScore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static void displaySemester(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("----------Semester List:----------");
        //Access every element of semester table
        for(Semester s : (List<Semester>)session.createQuery("From Semester").getResultList()){
            System.out.println(s.getSemesterId() +"--"+s.getName());
        }
        session.close();
    }
    
    private static void displayCourseBySemester(Semester semester){
        Session session = HibernateUtils.getSessionFactory().openSession();
        System.out.println("----------Course List:----------");
        int i=0;
        //Access every element of semester table
        for(Course c : semester.getCourseList()){
            System.out.println(++i+"--"+c.getName());
        }
        session.close();
    }

    private Semester getSemesterById(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return (Semester)session.createQuery("From Semester Where semesterId = "+id).getResultList().get(0);
    }
    
    private Course getCourseByName(String name) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return (Course)session.createQuery("From Course where name = '"+name+"'").getResultList().get(0);
    }

    private void displayStudentListByCourse(Course course) {
        System.out.println("----------Student List:----------");
        int i = 0;
        //Access every student in a course
        for(Student s : course.getStudentList()){
            System.out.println(++i +"--"+ s.getStudentId() +"--" + s.getFirstName()+" "+s.getLastName());
        }
    }

    private Grade getStudentGradeByStudentId(String studentId) {
        return (Grade)HibernateUtils.getSessionFactory().openSession().createQuery("From Grade\n" +
"where student.studentId = '"+studentId+"'").getResultList().get(0);
    }

    private void displayStudentGrade(Grade grade) {
    }
}