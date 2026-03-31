package aidriven_resume_screening_system;

public abstract class JobRole {
    abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    String getRoleName() {
        return "Product Manager";
    }
}
