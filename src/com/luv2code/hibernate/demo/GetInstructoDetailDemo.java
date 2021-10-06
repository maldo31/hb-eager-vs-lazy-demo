package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructoDetailDemo {

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


            //start a transaction
            session.beginTransaction();
            //get instructor detail objects

            int theId = 2999;
            InstructorDetail tempInstructorDetial = session.get(InstructorDetail.class,theId);

            //print instructor detal

            System.out.println("tempInstructorDetail: " + tempInstructorDetial);

            System.out.println("the associated instructor: " + tempInstructorDetial.getInstructor());



            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {

            session.close();
            factory.close();
        }
    }
}
