package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Client;
import org.example.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {
    public static void createPayment(Payment payment){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        }
    }
    public static Payment getPaymentById(long id){
        Payment payment;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            payment = session.get(Payment.class,id);
            transaction.commit();
        }
        return payment;
    }
    public static List<Payment > getPayments(){
        List<Payment> payments;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            payments =session.createQuery("Select c from Payment c", Payment.class).getResultList();
            transaction.commit();
        }
        return  payments;
    }
    
    public static Payment updatePayment(Payment payment){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(payment);
            transaction.commit();
        }
        return payment;
    }
    public static void deletePayment(Payment payment){
        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(payment);
            transaction.commit();
        }
    }

    public static void clientPay(Payment payment){
        BigDecimal cost = TransportationDao.getTransportationCost(payment.getTransportation().getId());
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            payment.setCost(cost);
            session.save(payment);
            transaction.commit();

        }
    }
    public static boolean wasClientPaing(Client client){
        boolean paid=false;
        long clientId = client.getId();
        List<Payment> payments= new ArrayList<Payment>();
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            payments = session.createQuery("Select p from Payment p " +
                    "join fetch p.client" ,
                    Payment.class) .getResultList();
            transaction.commit();
        }
        for (Payment payment:payments){
            if (payment.getClient().getId() == clientId && payment.getPaid() == null){
                return false;
            }
        }
        return true;
    }

}
