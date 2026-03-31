import java.sql.*;
import java.io.*;

public class DBToCSV {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "password");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, name, department, salary FROM employee");

        BufferedWriter bw = new BufferedWriter(new FileWriter("employees_report.csv"));

        bw.write("Employee ID,Name,Department,Salary");
        bw.newLine();

        while (rs.next()) {
            bw.write(
                rs.getInt("id") + "," +
                rs.getString("name") + "," +
                rs.getString("department") + "," +
                rs.getDouble("salary")
            );
            bw.newLine();
        }

        bw.close();
        con.close();

        System.out.println("CSV report generated successfully");
    }
}
