package repository;

import model.CompanyEmpWage;
import java.util.HashMap;

public class CompanyRepository implements ICompanyRepository {

    private HashMap<String, CompanyEmpWage> companyMap = new HashMap<>();

    public void addCompany(CompanyEmpWage company){
        companyMap.put(company.getCompanyName(), company);
    }

    public CompanyEmpWage getCompany(String name){
        return companyMap.get(name);
    }
}
