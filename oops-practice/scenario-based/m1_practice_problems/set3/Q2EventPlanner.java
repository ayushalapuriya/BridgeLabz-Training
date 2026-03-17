package m1_practice_problems.set3;

import java.util.*;

abstract class Festival {
    String name, location, date;

    Festival(String n, String l, String d) {
        name = n;
        location = l;
        date = d;
    }

    abstract void display();
}

class MusicFestival extends Festival {

    String headliner, genre;
    int ticketPrice;

    MusicFestival(String n, String l, String d,
                  String h, String g, int p) {
        super(n, l, d);
        headliner = h;
        genre = g;
        ticketPrice = p;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

class FoodFestival extends Festival {

    String cuisine;
    int stalls, entryFee;

    FoodFestival(String n, String l, String d,
                 String c, int s, int f) {
        super(n, l, d);
        cuisine = c;
        stalls = s;
        entryFee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + stalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

class ArtFestival extends Festival {

    String artType;
    int artists, fee;

    ArtFestival(String n, String l, String d,
                String a, int ar, int f) {
        super(n, l, d);
        artType = a;
        artists = ar;
        fee = f;
    }

    void display() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + artists);
        System.out.println("Exhibition Fee: " + fee);
    }
}

public class Q2EventPlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        while (true) {

            String line = sc.nextLine();
            if (line.equals("EXIT"))
                break;

            String[] cmd = line.split(" ");

            if (cmd[0].equals("ADD_FESTIVAL")) {

                String type = cmd[1];

                if (type.equals("MUSIC")) {
                    map.put(cmd[2],
                            new MusicFestival(cmd[2], cmd[3], cmd[4],
                                    cmd[5], cmd[6],
                                    Integer.parseInt(cmd[7])));
                }

                else if (type.equals("FOOD")) {
                    map.put(cmd[2],
                            new FoodFestival(cmd[2], cmd[3], cmd[4],
                                    cmd[5],
                                    Integer.parseInt(cmd[6]),
                                    Integer.parseInt(cmd[7])));
                }

                else if (type.equals("ART")) {
                    map.put(cmd[2],
                            new ArtFestival(cmd[2], cmd[3], cmd[4],
                                    cmd[5],
                                    Integer.parseInt(cmd[6]),
                                    Integer.parseInt(cmd[7])));
                }
            }

            else if (cmd[0].equals("DISPLAY_DETAILS")) {

                Festival f = map.get(cmd[1]);
                if (f != null)
                    f.display();
            }
        }
    }
}