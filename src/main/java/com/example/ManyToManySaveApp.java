package com.example;

import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManySaveApp {
    public static void main(String[] args) {
        //stworznie obiektu Configuration
        Configuration conf = new Configuration();
        //wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Training.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobiranie sesji
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Training training = new Training("sales training");
        Employee employee = new Employee("Johny", "Depp", 16000);
        Employee employee1 = new Employee("Miley", "Cyrus", 16000);

        training.addEmployee(employee);
        training.addEmployee(employee1);

        session.persist(training);

        session.getTransaction().commit();

        //zamkniecie obiektu SessionFactory
        factory.close();
    }
}
