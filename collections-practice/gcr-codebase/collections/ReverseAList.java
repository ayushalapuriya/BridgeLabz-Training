import java.util.*;

public class ReverseAList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers for the list separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String num : input) {
            list.add(Integer.parseInt(num));
        }

        List<Integer> reversed = reverseList(list);

        System.out.println("Original List: " + list);
        System.out.println("Reversed List: " + reversed);
        
        sc.close();
    }

    public static List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
}
