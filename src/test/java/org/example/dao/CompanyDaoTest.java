package org.example.dao;

import jakarta.persistence.EntityNotFoundException;
import org.example.entity.Company;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDaoTest {

    @Test
    void createCompany() {
        BigDecimal income = new BigDecimal(0);
        Company company = new Company("Speedy", "Bulgaria", "Sofia",income);
        CompanyDao.createCompany(company);
        assertEquals(1,CompanyDao.getCompanyById(1).getId());
    }

    @Test
    void saveCompanyDto() {
    }

    @Test
    void getCompanyById_Success() {
        long id =1;
        BigDecimal income = new BigDecimal(0);
        Company company = new Company("Speedy", "Bulgaria", "Sofia",income);
        CompanyDao.createCompany(company);
        assertEquals("Speedy",CompanyDao.getCompanyById(id).getName());
    }
    @Test
    public void testGetCompanyById_NotFound() {
        assertThrows(EntityNotFoundException.class, () -> CompanyDao.getCompanyById(999L));
    }

    @Test
    void getCompanies() {
        BigDecimal income = new BigDecimal(0);
        Company company1 = new Company("Speedy", "Bulgaria", "Sofia",income);
        Company company2 = new Company("Speedy", "Bulgaria", "Sofia",income);
        CompanyDao.createCompany(company1);
        CompanyDao.createCompany(company2);
        List<Company> companies = CompanyDao.getCompanies();
        assertEquals(2, companies.size());
        assertEquals(1, companies.get(0).getId());
    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteCompany() {
    }

    @Test
    void getCompanyEmployee() {
    }

    @Test
    void updateCompanyNoEmployee() {
    }

    @Test
    void getCompanyVehicles() {
    }

    @Test
    void companiesWithNameLike() {
    }

    @Test
    void getIncome() {
    }

    @Test
    void getCompaniesSortedByName() {
    }

    @Test
    void getCompaniesSortedByIncome() {
    }

    @Test
    void getPayments() {
    }
}