package org.example.services;

import org.example.dao.CompanyDao;

import java.math.BigDecimal;

public class CalculateCompanyIncome extends Thread{
    private long idCompany;
    public CalculateCompanyIncome(long idCompany){
        this.idCompany = idCompany;
    }
    @Override
    public void run(){
        try{
            BigDecimal income = CompanyService.calculateIncomeOfCompany(this.idCompany);
            System.out.println("========================= id:"+ CompanyDao.getCompanyById(idCompany).getId()+"Income of "+ CompanyDao.getCompanyById(idCompany).getName()+ ": " + income + "========================");
            Thread.sleep(1000);

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
