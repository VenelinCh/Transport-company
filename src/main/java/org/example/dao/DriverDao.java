package org.example.dao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.Driver;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DriverDao {
    public static void createDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }
    public static Driver getDriverById(long id){
        Driver driver;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driver = session.get(Driver.class,id);
            transaction.commit();
        }
        return driver;
    }
    public static List<Driver > getDrivers(){
        List<Driver> drivers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            drivers =session.createQuery("Select d from Driver d", Driver.class).getResultList();
            transaction.commit();
        }
        return  drivers;
    }
    public static List<Driver> driversWhithNameLike(String name){
        List<Driver> drivers;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.select(root).where(cb.like(root.get("name"), "%"+ name + "%"));
            Query query = session.createQuery(cr);
            drivers = query.getResultList();

        }
        return drivers;
    }
    public static Driver updateDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
        return driver;
    }
    public static void deleteDriver(Driver driver){
        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(driver);
            transaction.commit();
        }
    }
    //    public static Set<Driver> findDriversByCompany(long id){
//        Set<Driver>drivers;
//        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
//            Transaction transaction = session.beginTransaction();
//
//            //session.delete(driver);
//            transaction.commit();
//        }
//    }
    public static Set<Company> getCompanies(long id){
        Driver driver;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            driver = session.createQuery("select e from Driver e" +
                                    " join fetch e.drivers" +
                                    " where e.id = :id",
                            Driver.class)
                    .setParameter("id",id)
                    .getSingleResult();
            transaction.commit();
        }
        return driver.getCompanies();
    }
}
