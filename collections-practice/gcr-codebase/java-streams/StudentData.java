import java.io.*;

public class StudentData {
    public static void main(String[] args) throws IOException {
        // Write data
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("John");
            dos.writeDouble(8.5);
        }

        // Read data
        try (DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"))) {
            System.out.println("Roll: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA: " + dis.readDouble());
        }
    }
}
