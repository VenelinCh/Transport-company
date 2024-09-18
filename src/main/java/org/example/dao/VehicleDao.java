package org.example.dao;

import jakarta.persistence.NoResultException;
import org.example.configuration.SessionFactoryUtil;

import org.example.entity.Company;
import org.example.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VehicleDao {
    public static void createVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }
    public static Vehicle getVehicleById(long id){
        Vehicle vehicle;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class,id);
            transaction.commit();
        }
        return vehicle;
    }
    public static List<Vehicle > getVehicles(){
        List<Vehicle> vehicles;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicles =session.createQuery("Select v from Vehicle v", Vehicle.class).getResultList();
            transaction.commit();
        }
        return  vehicles;
    }
    public static Vehicle getVehicleByRegistration(String registration){
        Vehicle vehicle = null;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            vehicle = session.createQuery(
                            "select v from Vehicle v" +
                                    " where v.registration = :registration",
                            Vehicle.class)
                    .setParameter("registration", registration)
                    .getSingleResult();
            transaction.commit();
        }catch(NoResultException e){
            System.out.println(e);
        }
        return vehicle;
    }
    public static Vehicle updateVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
        return vehicle;
    }
    public static void deleteVehicle(Vehicle vehicle){
        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }

}
