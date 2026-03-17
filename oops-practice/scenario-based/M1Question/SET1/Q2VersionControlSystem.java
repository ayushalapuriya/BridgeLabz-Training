package M1Question.SET1;

import java.util.*;

class FileVersion {
    String version;
    int size;

    FileVersion(String v, int s) {
        version = v;
        size = s;
    }
}

public class Q2VersionControlSystem {

    static Map<String, List<FileVersion>> map = new HashMap<>();
    static Map<String, FileVersion> latest = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String[] cmd = sc.nextLine().split(" ");

            switch (cmd[0]) {

                case "UPLOAD":

                    String file = cmd[1];
                    String version = cmd[2];
                    int size = Integer.parseInt(cmd[3]);

                    map.putIfAbsent(file, new ArrayList<>());

                    boolean exists = false;
                    for (FileVersion v : map.get(file)) {
                        if (v.version.equals(version)) {
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        FileVersion fv = new FileVersion(version, size);
                        map.get(file).add(fv);
                        latest.put(file, fv);
                    }

                    break;

                case "FETCH":

                    file = cmd[1];

                    if (!map.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    List<FileVersion> list = new ArrayList<>(map.get(file));

                    list.sort((a, b) -> {
                        if (a.size != b.size)
                            return a.size - b.size;
                        return a.version.compareTo(b.version);
                    });

                    for (FileVersion v : list) {
                        System.out.println(file + " " + v.version + " " + v.size);
                    }

                    break;

                case "LATEST":

                    file = cmd[1];

                    if (!latest.containsKey(file)) {
                        System.out.println("File Not Found");
                    } else {
                        FileVersion v = latest.get(file);
                        System.out.println(file + " " + v.version + " " + v.size);
                    }

                    break;

                case "TOTAL_STORAGE":

                    file = cmd[1];

                    if (!map.containsKey(file)) {
                        System.out.println("File Not Found");
                        break;
                    }

                    int sum = 0;
                    for (FileVersion v : map.get(file))
                        sum += v.size;

                    System.out.println(file + " " + sum);
            }
        }
    }
}