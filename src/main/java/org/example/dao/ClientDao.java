package org.example.dao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDao {
    public static void createClient(Client client){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public static Client updateClient(Client client){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
        return client;
    }
    public static void deleteClient(Client client){
        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
    public static Client getClientById(long id){
        Client client;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            client = session.get(Client.class,id);
            transaction.commit();
        }
        return client;
    }
    public static List<Client > getClients(){
        List<Client> clients;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            clients =session.createQuery("Select c from Client c", Client.class).getResultList();
            transaction.commit();
        }
        return  clients;
    }

    public static List<Client> clientsWithFirstNameLike(String name){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr =cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            cr.select(root).where(cb.like(root.get("name"), "%" + name + "%"));
            Query query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }
    public static List<Client> clientsWithNameLike(String name, String lastName){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Client> cr = cb.createQuery(Client.class);
            Root<Client> root = cr.from(Client.class);
            Predicate predicateForName = cb.equal(root.get("name"),name);
            Predicate predicateForLastName = cb.equal(root.get("lastName"),lastName);
            Predicate predicateAnd = cb.and(predicateForName,predicateForLastName);
            cr.where(predicateAnd);
            Query query = session.createQuery(cr);
            List<Client> clients = query.getResultList();
            return clients;
        }
    }

}
