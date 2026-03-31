package service;

import model.CompanyEmpWage;
import repository.CompanyRepository;

public class EmpWageService implements IEmpWageService {

    private CompanyRepository repository = new CompanyRepository();

    public void addCompany(String name,
                           int wagePerHour,
                           int workingDays,
                           int maxHours){

        CompanyEmpWage company =
                new CompanyEmpWage(name,
                                   wagePerHour,
                                   workingDays,
                                   maxHours);

        repository.addCompany(company);
    }

    public void computeWage(String companyName){

        CompanyEmpWage company =
                repository.getCompany(companyName);

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        while(totalHours <= company.getMaxHours() &&
              totalDays < company.getWorkingDays()){

            totalDays++;

            int empHours = 0;

            int attendance = (int)(Math.random()*3);

            switch(attendance){

                case 1:
                    empHours = 8;
                    break;

                case 2:
                    empHours = 4;
                    break;

                default:
                    empHours = 0;
            }

            totalHours += empHours;

            int dailyWage =
                    empHours * company.getWagePerHour();

            company.addDailyWage(dailyWage);

            totalWage += dailyWage;
        }

        company.setTotalWage(totalWage);
    }

    public int getTotalWage(String companyName){
        return repository.getCompany(companyName)
                .getTotalWage();
    }
}
