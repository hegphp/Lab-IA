/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.henrygphp.nhapdiem;

import com.henrygphp.NhapDiem.utils.GradeManager;
import com.henrygphp.NhapDiem.utils.HibernateUtils;
import com.henrygphp.nhapdiem.entities.Course;
import com.henrygphp.nhapdiem.entities.Grade;
import com.henrygphp.nhapdiem.entities.Grade_Score;
import com.henrygphp.nhapdiem.entities.Score;
import com.henrygphp.nhapdiem.entities.Semester;
import com.henrygphp.nhapdiem.entities.Student;
import com.henrygphp.nhapdiem.entities.Subject;
import com.henrygphp.nhapdiem.entities.SubjectType;
import com.henrygphp.nhapdiem.entities.Teacher;
import jakarta.persistence.Query;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Hegphp
 */
public class NhapDiem {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        GradeManager manage = new GradeManager();
        //Loop until user choose exit
        while (true) {
            addData();
            //display menu
            displayMenu();
            //Input user's choice
            System.out.print("Input your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            //Run fuction depends on user's choice
            switch (choice) {
                //Option 1: Show infomation
                case 1:
                    manage.showInformation();
                    break;
                //Option 2: Update Score
                case 2:
                    manage.updateScore();
                    break;
                //Option 3: Exit
                default:
                    HibernateUtils.shutdown();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void addData() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            //Create a transaction
            session.beginTransaction();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<Semester> semesterList = session.createQuery("From Semester").getResultList();
            //Insert subject type data (if empty)--------------------------------------------------------
            //Check if Semester Database is empty or not
            if (semesterList.isEmpty()) {
                Semester semester1 = new Semester(new Date(sdf.parse("01/01/2003").getTime()), new Date(sdf.parse("30/04/2003").getTime()), "Spring 2003");
                Semester semester2 = new Semester(new Date(sdf.parse("01/05/2003").getTime()), new Date(sdf.parse("31/08/2003").getTime()), "Summer 2003");
                Semester semester3 = new Semester(new Date(sdf.parse("01/09/2003").getTime()), new Date(sdf.parse("31/12/2003").getTime()), "Fall 2003");
                Semester semester4 = new Semester(new Date(sdf.parse("01/01/2004").getTime()), new Date(sdf.parse("30/04/2003").getTime()), "Spring 2004");
                Semester semester5 = new Semester(new Date(sdf.parse("01/05/2004").getTime()), new Date(sdf.parse("31/08/2003").getTime()), "Summer 2004");

                session.persist(semester1);
                session.persist(semester2);
                session.persist(semester3);
                session.persist(semester4);
                session.persist(semester5);
                session.flush();
            }

            //Insert subject type data--------------------------------------------------------
            List<SubjectType> typeList = session.createQuery("From SubjectType").getResultList();
            //check if SubjectType database is empty or not
            if (typeList.isEmpty()) {
                SubjectType type1 = new SubjectType("Software Engineering");
                SubjectType type2 = new SubjectType("Computing Fundamental");
                SubjectType type3 = new SubjectType("Japanese");
                SubjectType type4 = new SubjectType("Mathematics");
                SubjectType type5 = new SubjectType("English Preparation Course");

                session.persist(type1);
                session.persist(type2);
                session.persist(type3);
                session.persist(type4);
                session.persist(type5);
            }
            //Insert subject data ---------------------------------------------------------------
            List<Subject> subjectList = session.createQuery("From Subject").getResultList();
            //check if the Subject table is empty or not
            if (subjectList.isEmpty()) {
                Query query = session.createQuery("From SubjectType");
                SubjectType type = session.get(SubjectType.class, new Integer(1));
                Subject subject1 = new Subject("SWT301", "Software Testing", type, 3, 5250000, 6825000);
                Subject subject2 = new Subject("SWR302", "Software Requirement", type, 3, 5250000, 6825000);
                Subject subject3 = new Subject("SWP391", "Application development project", type, 3, 5250000, 6825000);
                Subject subject4 = new Subject("SWE201c", "Introduction to Software Enginerring", type, 3, 5250000, 6825000);
                Subject subject5 = new Subject("SWD392", "SW Architecture and Design", type, 3, 5250000, 6825000);

                session.persist(subject1);
                session.persist(subject2);
                session.persist(subject3);
                session.persist(subject4);
                session.persist(subject5);
            }

            //insert Student data --------------------------------------------------
            //check if Student table is empty or not
            if (session.createQuery("From Student").list().isEmpty()) {
                Student student1 = new Student("HE171254", "Viet Hong", "Bui", "Hai Phong, Vietnam", "hongbvhe171254@fpt.edu.vn", "0387718770");
                Student student2 = new Student("HE171255", "Hoang Thang", "Nguyen", "HaiPhong, Vietnam", "he171255@fpt.edu.vn", "0387718771");
                Student student3 = new Student("HE171256", "Nam Hai", "Kieu", "Ha Noi, Vietnam", "he171256@fpt.edu.vn", "0387718772");
                Student student4 = new Student("HE171257", "Quang Loi", "Nguyen", "Thai Binh, Vietnam", "he171257@fpt.edu.vn", "0387718773");
                Student student5 = new Student("HE171258", "Dinh Anh Duc", "Nguyen", "Ha Noi, Vietnam", "he171258@fpt.edu.vn", "0387718774");

                session.persist(student1);
                session.persist(student2);
                session.persist(student3);
                session.persist(student4);
                session.persist(student5);
            }

            //insert Teacher data
            //Check if Teacher table is empty or not
            if (session.createQuery("From Teacher").getResultList().isEmpty()) {
                Teacher teacher1 = new Teacher("Sonnt5", "Tung Son", "Ngo", "Vietnam", "sonnt5@fe.edu.vn", "");
                Teacher teacher2 = new Teacher("TuanVM2", "Minh Tuan", "Vuong", "Vietnam", "tuanvm2@fe.edu.vn", "");
                Teacher teacher3 = new Teacher("HaiLT", "Thanh Hai", "Le", "Vietnam", "hailt10@fe.edu.vn", "");
                Teacher teacher4 = new Teacher("BanTQ", "Quy Ban", "Tran", "Vietnam", "	BanTQ3@fe.edu.vn", "");
                Teacher teacher5 = new Teacher("ChiLP", "Phuong Chi", "Le", "Vietnam", "ChiLP2@fe.edu.vn", "");

                session.persist(teacher1);
                session.persist(teacher2);
                session.persist(teacher3);
                session.persist(teacher4);
                session.persist(teacher5);
            }
            //insert Course data
            //Check if course table is empty or not
            if (session.createQuery("From Course").list().isEmpty()) {
                List<Course> courseInputList = new ArrayList<Course>();

                Subject subject = session.get(Subject.class, new String("SWT"));

                List<Subject> subjects = new ArrayList();
                subjects.add(session.get(Subject.class, new String("SWT301")));
                subjects.add(session.get(Subject.class, new String("SWR302")));
                subjects.add(session.get(Subject.class, new String("SWP391")));
                subjects.add(session.get(Subject.class, new String("SWE201c")));
                subjects.add(session.get(Subject.class, new String("SWD392")));

                List<Semester> semesters = new ArrayList();
                semesters.add(session.get(Semester.class, new Integer(1)));

                List<Student> students = session.createQuery("From Student").getResultList();

                courseInputList.add(new Course("SE1737", subjects.get(0), semesters.get(0)));
                courseInputList.add(new Course("SE1738", subjects.get(1), semesters.get(0)));
                courseInputList.add(new Course("SE1739", subjects.get(2), semesters.get(0)));
                courseInputList.add(new Course("SE1740", subjects.get(3), semesters.get(0)));
                courseInputList.add(new Course("SE1741", subjects.get(4), semesters.get(0)));

                //Add students on Course: SE1737
                for (int i = 0; i < students.size(); i++) {
                    courseInputList.get(0).getStudentList().add(students.get(i));
                    session.persist(courseInputList.get(i));
                }
            }
            //Insert Score data
//            Check if Score table is empty or not
            if (session.createQuery("From Score").getResultList().isEmpty()) {
                List<Score> scores = new ArrayList();
                scores.add(new Score("PE", "Practice Exam"));
                scores.add(new Score("FE", "Final Exam"));
                scores.add(new Score("PT", "Progress test"));
                scores.add(new Score("Asignment", "Assignment"));
                scores.add(new Score("Presentation", "Presentation"));
                //Save scores list to database
                for (Score s : scores) {
                    session.persist(s);
                }
            }

            //Insert grade data
            //Insert Grade_Score table
//            if(session.createQuery("From Grade_Score").getResultList().isEmpty()){
//                Grade grade = session.get(Grade.class, new Integer(23));
//                
//                Grade_Score grade_Score = new Grade_Score();
//                grade_Score.setGrade(grade);
//                grade_Score.setScore();
//            }
            session.flush();
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void displayMenu() {
        System.out.println("Welcome to my first application using Hibernate!\n"
                + "Choose your option:\n"
                + "1. Display information\n"
                + "2. Change score\n"
                + "3. Exit");
    }
}
