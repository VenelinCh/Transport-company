package org.example;

import jakarta.persistence.criteria.Path;
import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();
        Company company = new Company("New company", "Bulgaria", "Sofia");
//        CompanyDao.createCompany(company);
        company = CompanyDao.getCompanyById(1);
        Vehicle vehicle = new Vehicle("truck","CA2321BA", "Volvo", "Model 12");
//        VehicleDao.createVehicle(vehicle);
        vehicle = VehicleDao.getVehicleById(1);
        Driver driver = new Driver("Ivan", "Todorov", "C1", 3000);
//        DriverDao.createDriver(driver);
        driver = DriverDao.getDriverById(1);
        Set<Driver> drivers= new HashSet<>();
        drivers.add(driver);
        Transportation transportation = new Transportation("point a", "point b", LocalDate.of(2024,2,4),LocalDate.of(2024,2,14),vehicle,drivers,company, BigDecimal.valueOf(500));
        //transportation.setPayed(false);
//        TransportationDao.deleteTransportation(TransportationDao.getTransportationById(9));
//        TransportationDao.deleteTransportation(TransportationDao.getTransportationById(10));
//        TransportationDao.createTransportation(transportation);
        Set<Vehicle> vehicles= CompanyDao.getCompanyVehicles(1);
        for(Vehicle v :vehicles){
            System.out.println(v);
        }
        Client client = new Client("Ivan", "Velev");
        //ClientDao.createClient(client);
        client = ClientDao.getClientById(1);
        transportation = TransportationDao.getTransportationById(8);
        Payment payment = new Payment(client,transportation, company);
        //PaymentDao.updatePayment(payment);
        List<Client> clients = ClientDao.clientsWithNameLike("Ivan","Velev");
        for(Client cl: clients){
            System.out.println(cl);
            //System.out.println("Payed: " + PaymentDao.wasClientPaing(cl));
        }
        client = ClientDao.getClientById(1);
        System.out.println(PaymentDao.wasClientPaing(client)?"Payed" : "Not payed");
        System.out.println(CompanyDao.getCompanyById(1) + "has income" + CompanyDao.getIncome(1));
        List<Employee> employees = EmployeeDao.getEmployeesSortByQualificationAsc();
        for (Employee e :employees){
            System.out.println(e);
        }
        List<Transportation>tr = TransportationDao.getTransportationsSortByDestinationASC();
        for(Transportation t:tr){
            System.out.println(t);
        }
        Long count = TransportationDao.countByCompany(1);
        System.out.println(count);
        BigDecimal sum = TransportationDao.getTransportationCost(1);
        System.out.println("profit=" + sum);

        List<Payment> payments = PaymentDao.getPayments();
//
        OutputFile outputFile = new OutputFile<>(employees);
        outputFile.output("employees.txt");
    }
}