package org.example.services;
import org.example.dao.CompanyDao;
import org.example.dao.PaymentDao;
import org.example.entity.Company;
import org.example.entity.Payment;

import java.math.BigDecimal;
import java.util.List;

public class CompanyService {
     public static BigDecimal calculateIncomeOfCompany(long id){
         BigDecimal income = new BigDecimal(0);
         Company company = CompanyDao.getCompanyById(id);
         List<Payment> payments = PaymentDao.getAllPayments();
         for(Payment p : payments){
            if(id == p.getToCompany().getId()){
                income = income.add(p.getCost());
            }
         }
         return income;
     }
}
