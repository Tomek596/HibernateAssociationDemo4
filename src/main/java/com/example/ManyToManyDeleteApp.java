package com.example;

import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDeleteApp {
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

        int idEmployee = 121;
        int idTraining = 1;

        session.beginTransaction();

//        Employee employee = session.get(Employee.class, idEmployee);
//        session.delete(employee);

        Training training = session.get(Training.class, idTraining);
        session.delete(training);
        session.getTransaction().commit();

        //zamkniecie obiektu SessionFactory
        factory.close();
    }
}
