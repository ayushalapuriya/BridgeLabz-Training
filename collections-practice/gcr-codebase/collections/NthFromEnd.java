import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of the list separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(input));

        System.out.print("Enter N (element from the end to retrieve): ");
        int n = sc.nextInt();

        String result = findNthFromEnd(list, n);
        if (result != null) {
            System.out.println("The " + n + "th element from the end is: " + result);
        } else {
            System.out.println("Invalid N (larger than the list size).");
        }
        sc.close();
    }

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        for (int i = 0; i < n; i++) {
            if (first.hasNext()) first.next();
            else return null;
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }
}
