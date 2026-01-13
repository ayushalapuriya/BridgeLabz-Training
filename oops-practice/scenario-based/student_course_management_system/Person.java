package student_course_management_system;

public class Person {
    private int roll;
    private String name;
    private String phoneNo;

    public Person(int roll, String name, String phoneNo) {
        this.roll = roll;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void displayPersonDetails() {
        System.out.println("Roll No : " + roll);
        System.out.println("Name    : " + name);
        System.out.println("Phone   : " + phoneNo);
    }
}
