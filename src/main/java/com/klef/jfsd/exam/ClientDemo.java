package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            insertDepartment(session, "Computer Science", "Guntur", "Harsha");
            insertDepartment(session, "Electrical Engineering", "Guntur", "Vardhan");

            deleteDepartment(session, 1L);

        } finally {
            factory.close();
        }
    }

    public static void insertDepartment(Session session, String name, String location, String hodName) {
        // Create a Department object
        Department newDepartment = new Department(name, location, hodName);

        // Begin a transaction, save the object, and commit
        Transaction transaction = session.beginTransaction();
        session.persist(newDepartment);
        transaction.commit();

        System.out.println("Department inserted: " + newDepartment);
    }

    public static void deleteDepartment(Session session, long departmentId) {
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM department WHERE id = :deptId");
        query.setParameter("deptId", departmentId);

        int result = query.executeUpdate();

        transaction.commit();

        if (result > 0) {
            System.out.println("Department with ID " + departmentId + " deleted successfully.");
        } else {
            System.out.println("No department found with ID " + departmentId);
        }
    }
}
