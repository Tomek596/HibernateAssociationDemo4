package com.example;

import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class ManyToManyGetApp {
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

        int id = 1;
        int idEmployee = 120;
        int idEmployee1 = 121;

        session.beginTransaction();

//        Training training = new Training("java training");
//
//        Employee employee = session.get(Employee.class, idEmployee);
//        Employee employee1 = session.get(Employee.class, idEmployee1);
//
//        training.addEmployee(employee);
//        training.addEmployee(employee1);
//
//        session.persist(training);

        String getTraining = "from Training";
        Query query = session.createQuery(getTraining);

        List<Training> resultList = query.getResultList();

        for(Training training : resultList){
            System.out.println(training);
            for (Employee employee : training.getEmployees()){
                System.out.println("- " + employee);
            }
        }

//        Training training = session.get(Training.class, id);
//
//        System.out.println(training);
//
//        for(Employee employee : training.getEmployees()){
//            System.out.println("- " + employee);
//        }

        session.getTransaction().commit();

        //zamkniecie obiektu SessionFactory
        factory.close();
    }
}
