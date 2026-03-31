import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers for the list separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String num : input) list.add(Integer.parseInt(num));

        System.out.print("Enter number of positions to rotate: ");
        int rotateBy = sc.nextInt();

        Collections.rotate(list, -rotateBy);
        System.out.println("Rotated List: " + list);
        
        sc.close();
    }
}
