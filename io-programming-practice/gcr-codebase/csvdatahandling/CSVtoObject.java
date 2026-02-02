import java.io.*;
import java.util.*;

class Student3 {
    int id, age, marks;
    String name;
    Student3(int i,String n,int a,int m){id=i;name=n;age=a;marks=m;}
    public String toString(){return id+" "+name+" "+age+" "+marks;}
}

public class CSVtoObject {
    public static void main(String[] args) throws Exception {
        List<Student3> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alapu\\Downloads\\students.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Student3(
                Integer.parseInt(d[0]), d[1],
                Integer.parseInt(d[2]), Integer.parseInt(d[3])));
        }
        list.forEach(System.out::println);
        
        br.close();
    }
}
