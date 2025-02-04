package org.example;

import org.example.Dto.PaymentDTO;
import org.example.configuration.SessionFactoryUtil;
import org.example.dao.*;
import org.example.entity.*;
import org.example.exceptions.CompanyException;
import org.example.services.CalculateCompanyIncome;
import org.example.services.OutputFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();
        String name ="DHL";
        String city="Sofia";
        String country="Bulgaria";
        BigDecimal income = new BigDecimal(0);

        Company company = new Company();
        company.setName(name);
        company.setCountry(country);
        company.setCity(city);
        company.setIncome(income);
        try {
//            CompanyDao.createCompany(company);
        }catch (CompanyException e){
            System.err.println("Exception occurred: " + e.getMessage());
        }

        //Company company1 = CompanyDao.getCompanyById(1);

        CalculateCompanyIncome calculate = new CalculateCompanyIncome(1);
        CalculateCompanyIncome calculate1 = new CalculateCompanyIncome(2);
        CalculateCompanyIncome calculate2 = new CalculateCompanyIncome(3);
        Thread thread = calculate;
        Thread thread1 = calculate1;
        Thread thread2 = calculate2;
        thread.start();
        thread1.start();
        thread2.start();
        try{
            thread.join();
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

        //company = CompanyDao.getCompanyById(1);

        Vehicle vehicle = new Vehicle("truck","CA2321BA", "Volvo", "Model 12");
//        VehicleDao.createVehicle(vehicle);
     //   vehicle = VehicleDao.getVehicleById(1);

        Driver driver = new Driver("Ivan", "Todorov", "C1", 3002);
//        DriverDao.createDriver(driver);
        driver = DriverDao.getDriverById(1);
        Set<Driver> drivers= new HashSet<>();
        drivers.add(driver);

        Transportation transportation = new Transportation("point a", "point b", LocalDate.of(2024,2,4),LocalDate.of(2024,2,14),vehicle,drivers,company, BigDecimal.valueOf(500));
//        TransportationDao.createTransportation(transportation);

        Client client = new Client("Ivan", "Velev");
        //ClientDao.createClient(client);

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

        List<Payment> payments = PaymentDao.getAllPayments();

        OutputFile outputFile = new OutputFile<>(employees);
        outputFile.output("employees.txt");
        List<PaymentDTO> paymentDTOList = CompanyDao.getPayments(2);
        for(PaymentDTO p: paymentDTOList){
            System.out.println(p);
        }

        Menu.showMenu0();
    }
}