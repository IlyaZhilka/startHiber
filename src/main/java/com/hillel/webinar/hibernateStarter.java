package com.hillel.webinar;

import com.hillel.webinar.entity.Exam;
import com.hillel.webinar.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class hibernateStarter {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
/*
        Student student = new Student();
        student.setFirtsname("Vlad");
        student.setLastName("Popov");
        student.setAge(20);

        Student studentA = new Student();
        studentA.setFirtsname("Egor");
        studentA.setLastName("Chernenko");
        studentA.setAge(19);

        session.save(student);
        session.save(studentA);
*/

    Student student = session.get(Student.class,1);
        Set<Exam> exams = student.getExams();
        System.out.println();
  //  student.setAge(35);

        Query query = session.createQuery("from Student ");
        List<Student> students = query.getResultList();

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
