package com.henrygphp.NhapDiem.utils;


import com.henrygphp.nhapdiem.entities.Course;
import com.henrygphp.nhapdiem.entities.Grade;
import com.henrygphp.nhapdiem.entities.Grade_Score;
import com.henrygphp.nhapdiem.entities.Score;
import com.henrygphp.nhapdiem.entities.Semester;
import com.henrygphp.nhapdiem.entities.Student;
import com.henrygphp.nhapdiem.entities.Subject;
import com.henrygphp.nhapdiem.entities.SubjectType;
import com.henrygphp.nhapdiem.entities.Teacher;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hegphp
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;
    
    static{
        try{
            Configuration configuration = new Configuration();
            
            Properties properties = new Properties();
            properties.put(Environment.DRIVER,"org.mariadb.jdbc.Driver");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MariaDBDialect");
            properties.put(Environment.URL,"jdbc:mariadb://localhost:3306/test");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS,"admin");
            properties.put(Environment.SHOW_SQL,"true");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            configuration.setProperties(properties);
        
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Semester.class);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Subject.class);
            configuration.addAnnotatedClass(SubjectType.class);
            
            configuration.addAnnotatedClass(Grade_Score.class);
            configuration.addAnnotatedClass(Score.class);
            configuration.addAnnotatedClass(Grade.class);
            
        
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
}
