import java.util.LinkedList;
import java.util.Queue;

public class CircularTourProblem {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPump(PetrolPump[] pumps) {

        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.add(i);

        int start = 0;
        int surplus = 0;
        int count = 0;

        while (!queue.isEmpty() && count < n) {
            int i = queue.poll();
            surplus += pumps[i].petrol - pumps[i].distance;

            if (surplus < 0) {
                start = i + 1;
                surplus = 0;
                count = 0;
            } else {
                count++;
            }

            queue.add(i);
        }

        return (count == n) ? start : -1;
    }

    public static void main(String[] args) {

        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int start = findStartingPump(pumps);

        if (start == -1) {
            System.out.println("No possible tour");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }
    }
}
