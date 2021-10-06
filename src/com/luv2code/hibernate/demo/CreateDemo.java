package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args){
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try{
            //create objects
//            Instructor tempInstructor = new Instructor("Chad","Darby","darby@lub2code.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail(
//                    "http://www.luv2code.com/youtube",
//                    "lub 2 code!!!"
//            );
//            //associate objects together
//            tempInstructor.setInstructorDetail(tempInstructorDetail);
            Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@lub2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "http://www.youtube.com",
                    "Music"
            );
            //associate objects together
            tempInstructor.setInstructorDetail(tempInstructorDetail);


            //start a transaction
            session.beginTransaction();
            //save the instrucotr object

            System.out.println("Saving instructor: "+tempInstructor);
            session.save(tempInstructor);



            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
