import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("C:\\Users\\alapu\\Downloads\\employees.csv");
        fw.write("ID,Name,Dept,Salary\n");
        fw.write("1,Rahul,IT,50000\n");
        fw.write("2,Amit,HR,40000\n");
        fw.write("3,Priya,IT,60000\n");
        fw.write("4,Neha,Sales,45000\n");
        fw.write("5,Ankit,Finance,55000\n");
        System.out.println("Write file successfully");
        fw.close();
    }
}
