package org.example;
import org.example.dao.CompanyDao;
import org.example.entity.Company;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import static org.example.dao.CompanyDao.getCompanyById;

public class Menu {

    public static void showMenu0(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu Transport Company:");
            System.out.println("1. Show all");
            System.out.println("2. Edit ");
            System.out.println("3. Delete by id");
            System.out.println("4. Create new");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAllCompanies();
                    break;
                case 2:
                    editCompany();
                    break;
                case 3:
                    deleteCompany();
                    break;
                case 4:
                    newCompany();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
        System.out.print("Choose an option (1-5): ");
    }
    public static void showAllCompanies() {
        System.out.println("List of companies:\n");
        List<Company> companyList = CompanyDao.getCompanies();
        for (Company c: companyList){
            System.out.println( c+ "\n");
        }
    }

    public static void newCompany(){
        System.out.print("Enter the details of new company. ");
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.print("Name: ");
        name = scanner.nextLine();
        String country;
        System.out.print("Country: ");
        country = scanner.nextLine();
        BigDecimal income;
        System.out.print("Income: ");
        income = scanner.nextBigDecimal();
        //Set<Owner> owners
        //Set<Vehicle> vehicles;
        //Set<Employee> employees;
        Company company = new Company();
        company.setName(name);
        company.setCountry(country);
        company.setIncome(income);
        CompanyDao.createCompany(company);
    }
    public static void editCompany(){
        System.out.print("Enter the id of company. ");

        Scanner scanner = new Scanner(System.in);
        long id;
        id = scanner.nextLong();
        Company company = getCompanyById(id);
        String name;
        System.out.print("Name: ");
        name = scanner.nextLine();
        String country;
        System.out.print("Country: ");
        country = scanner.nextLine();
        BigDecimal income;
        System.out.print("Income: ");
        income = scanner.nextBigDecimal();
        //Set<Owner> owners
        //Set<Vehicle> vehicles;
        //Set<Employee> employees;
        company.setName(name);
        company.setCountry(country);
        company.setIncome(income);
        CompanyDao.updateCompany(company);

    }
    public static void deleteCompany(){
        System.out.print("Enter the id of company. ");
        Scanner scanner = new Scanner(System.in);
        long id;
        id = scanner.nextLong();
        Company company = getCompanyById(id);
        CompanyDao.deleteCompany(company);
    }

}
