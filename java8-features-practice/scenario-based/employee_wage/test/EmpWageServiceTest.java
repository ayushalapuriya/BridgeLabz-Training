package test;

import org.junit.jupiter.api.Test;
import service.EmpWageService;

import static org.junit.jupiter.api.Assertions.*;

public class EmpWageServiceTest {

    @Test
    void givenCompany_whenCompute_thenTotalWageShouldBeGreaterThanZero(){

        EmpWageService service = new EmpWageService();

        service.addCompany("TCS",20,20,100);

        service.computeWage("TCS");

        assertTrue(service.getTotalWage("TCS") > 0);
    }
}
