import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> b = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);

        Set<Integer> symDiff = new HashSet<>(union);
        symDiff.removeAll(intersection);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
        System.out.println("Symmetric Difference: " + symDiff);
    }
}
