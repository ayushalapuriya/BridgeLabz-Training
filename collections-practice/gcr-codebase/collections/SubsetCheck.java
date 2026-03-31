import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        Set<Integer> small = Set.of(2,3);
        Set<Integer> big = Set.of(1,2,3,4);

        System.out.println("Is subset: " + big.containsAll(small));
    }
}
