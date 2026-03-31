package presentation;

import service.EmpWageService;
import util.InputValidator;

public class EmployeeWageMain {

    public static void main(String[] args){

        System.out.println(
            "Welcome to Employee Wage Computation Program");

        EmpWageService service = new EmpWageService();

        String company = "TCS";

        if(InputValidator.validateCompanyName(company)){

            service.addCompany(company,20,20,100);

            service.computeWage(company);

            System.out.println("Total Wage = "
                    + service.getTotalWage(company));
        }
        else{
            System.out.println("Invalid Company Name");
        }
    }
}
