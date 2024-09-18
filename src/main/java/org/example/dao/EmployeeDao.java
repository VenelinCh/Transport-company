package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class EmployeeDao {
    public static void createEmployee(Employee employee){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }
    public static Employee getEmployeeById(long id){
        Employee employee;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee = session.get(Employee.class,id);
            transaction.commit();
        }
        return employee;
    }
    public static List<Employee > getEmployees(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =session.createQuery("Select e from Employee e", Employee.class).getResultList();
            transaction.commit();
        }
        return  employees;
    }
    public static Employee updateEmployee(Employee employee){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
        return employee;
    }
    public static void deleteEmployee(Employee employee){
        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
//    public static Set<Employee> findEmployeesByCompany(long id){
//        Set<Employee>employees;
//        try(Session session=SessionFactoryUtil.getSessionFactory().openSession()){
//            Transaction transaction = session.beginTransaction();
//
//            //session.delete(employee);
//            transaction.commit();
//        }
//    }
    public static Set<Company> getCompanies(long id){
        Employee employee;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee = session.createQuery("select e from Employee e" +
                                    " join fetch e.companies" +
                                    " where e.id = :id",
                            Employee.class)
                    .setParameter("id",id)
                    .getSingleResult();
            transaction.commit();
        }
        return employee.getCompanies();
    }
    public static List<Employee > getEmployeesSortBySalaryAsc(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =session.createQuery("Select e from Employee e order by e.salary ASC", Employee.class).getResultList();
            transaction.commit();
        }
        return  employees;
    }
    public static List<Employee > getEmployeesSortBySalaryDesc(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =session.createQuery("Select e from Employee e order by e.salary DESC", Employee.class).getResultList();
            transaction.commit();
        }
        return  employees;
    }
    public static List<Employee > getEmployeesSortByQualificationAsc(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =session.createQuery("Select e from Employee e order by e.qualification ASC", Employee.class).getResultList();
            transaction.commit();
        }
        return  employees;
    }
    public static List<Employee > getEmployeesSortByQualificationDesc(){
        List<Employee> employees;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employees =session.createQuery("Select e from Employee e order by e.qualification DESC", Employee.class).getResultList();
            transaction.commit();
        }
        return  employees;
    }


}
