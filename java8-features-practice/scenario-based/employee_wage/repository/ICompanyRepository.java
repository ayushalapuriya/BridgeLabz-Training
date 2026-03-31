package repository;

import model.CompanyEmpWage;

public interface ICompanyRepository {

    void addCompany(CompanyEmpWage company);

    CompanyEmpWage getCompany(String name);
}
