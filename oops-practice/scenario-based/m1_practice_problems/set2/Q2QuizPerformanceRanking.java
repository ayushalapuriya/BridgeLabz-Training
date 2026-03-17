package m1_practice_problems.set2;

import java.util.*;

class Student {
    String name;
    String dept;
    int q1, q2, q3;

    Student(String n, String d, int a, int b, int c) {
        name = n;
        dept = d;
        q1 = a;
        q2 = b;
        q3 = c;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class Q2QuizPerformanceRanking {

    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String[] cmd = sc.nextLine().split(" ");

            if (cmd[0].equals("Record")) {

                Student s = new Student(
                        cmd[1],
                        cmd[2],
                        Integer.parseInt(cmd[3]),
                        Integer.parseInt(cmd[4]),
                        Integer.parseInt(cmd[5])
                );

                list.add(s);

                System.out.println("Record Added: " + s.name);
            }

            else if (cmd[0].equals("Top")) {

                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String key = cmd[1];

                if (key.equals("Q1") || key.equals("Q2") || key.equals("Q3")) {

                    int max = -1;

                    for (Student s : list) {
                        int val = key.equals("Q1") ? s.q1 :
                                key.equals("Q2") ? s.q2 : s.q3;

                        max = Math.max(max, val);
                    }

                    for (Student s : list) {

                        int val = key.equals("Q1") ? s.q1 :
                                key.equals("Q2") ? s.q2 : s.q3;

                        if (val == max)
                            System.out.println(s.name + " " + val);
                    }

                } else {

                    int max = -1;

                    for (Student s : list) {
                        if (s.dept.equals(key))
                            max = Math.max(max, s.total());
                    }

                    if (max == -1) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(key) && s.total() == max)
                            System.out.println(s.name + " " + s.total());
                    }
                }
            }
        }
    }
}