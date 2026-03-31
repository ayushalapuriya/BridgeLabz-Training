package service;

public interface IEmpWageService {

    void addCompany(String name,
                    int wagePerHour,
                    int workingDays,
                    int maxHours);

    void computeWage(String companyName);

    int getTotalWage(String companyName);
}
