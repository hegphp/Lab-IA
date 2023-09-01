/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.henrygphp.nhapdiem;

import com.henrygphp.NhapDiem.utils.HibernateUtils;
import com.henrygphp.nhapdiem.entities.Student;
import com.henrygphp.nhapdiem.entities.Subject;
import com.henrygphp.nhapdiem.entities.SubjectType;
import jakarta.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Hegphp
 */
public class NhapDiem {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //Begin Transaction
            session.beginTransaction();
            //Insert Semester data
//            Semester semester1 = new Semester(new Date(sdf.parse("01/01/2003").getTime()), new Date(sdf.parse("30/04/2003").getTime()), "Spring 2003");
//            Semester semester2 = new Semester(new Date(sdf.parse("01/05/2003").getTime()), new Date(sdf.parse("31/08/2003").getTime()), "Summer 2003");
//            Semester semester3 = new Semester(new Date(sdf.parse("01/09/2003").getTime()), new Date(sdf.parse("31/12/2003").getTime()), "Fall 2003");
//            Semester semester4 = new Semester(new Date(sdf.parse("01/01/2003").getTime()), new Date(sdf.parse("30/04/2003").getTime()), "Spring 2004");
//            Semester semester5 = new Semester(new Date(sdf.parse("01/05/2003").getTime()), new Date(sdf.parse("31/08/2003").getTime()), "Summer 2004");
//            
//            session.save(semester1);
//            session.save(semester2);
//            session.save(semester3);
//            session.save(semester4);
//            session.save(semester5);
            
            //Insert subject type data--------------------------------------------------------
//            SubjectType type1 = new SubjectType("Software Engineering");
//            SubjectType type2 = new SubjectType("Computing Fundamental");
//            SubjectType type3 = new SubjectType("Japanese");
//            SubjectType type4 = new SubjectType("Mathematics");
//            SubjectType type5 = new SubjectType("English Preparation Course");
//            
//            session.save(type1);
//            session.save(type2);
//            session.save(type3);
//            session.save(type4);
//            session.save(type5);
            //Insert subject data ---------------------------------------------------------------
            Query query = session.createQuery("From SubjectType");
            List<SubjectType> result = query.getResultList();
//            Subject subject1 = new Subject("SWT301", "Software Testing", result.get(0), 3, 	5250000, 	6825000);
//            Subject subject2 = new Subject("SWR302", "Software Requirement", result.get(0), 3, 5250000, 6825000);
//            Subject subject3 = new Subject("SWP391", "Application development project", result.get(0), 3, 5250000, 6825000);
//            Subject subject4 = new Subject("SWE201c", "Introduction to Software Enginerring", result.get(0), 3, 5250000, 6825000);
//            Subject subject5 = new Subject("SWD392", "SW Architecture and Design", result.get(0), 3, 5250000, 6825000);
//            
//            session.save(subject1);
//            session.save(subject2);
//            session.save(subject3);
//            session.save(subject4);
//            session.save(subject5);
            
            //insert Student data --------------------------------------------------
            Student student1 = new Student("HE171254", "Viet Hong", "Bui", "HaiPhong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
            Student student2 = new Student("HE171254", "Viet Hong", "Bui", "HaiPhong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
            Student student3 = new Student("HE171254", "Viet Hong", "Bui", "HaiPhong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
            Student student4 = new Student("HE171254", "Viet Hong", "Bui", "HaiPhong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
            Student student5 = new Student("HE171254", "Viet Hong", "Bui", "HaiPhong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
            
            //insert Teacher data
            //insert Course data
            
            //insert Course data
            //insert grade data
            
            //Create menu
                   
            session.getTransaction().commit();
        }catch(Exception ex){
            if(session.getTransaction() != null && session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
            HibernateUtils.shutdown();
        }
    }
}
