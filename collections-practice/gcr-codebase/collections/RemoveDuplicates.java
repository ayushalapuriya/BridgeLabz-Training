import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers for the list separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String num : input) list.add(Integer.parseInt(num));

        Set<Integer> set = new LinkedHashSet<>(list);
        List<Integer> uniqueList = new ArrayList<>(set);

        System.out.println("Original List: " + list);
        System.out.println("List after removing duplicates: " + uniqueList);
        sc.close();
    }
}
