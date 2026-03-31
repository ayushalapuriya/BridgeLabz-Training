import java.time.*;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;
    Member(String n, LocalDate d) { name = n; expiryDate = d; }
}

public class MembershipFilter {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("John", LocalDate.now().plusDays(10)),
            new Member("Alice", LocalDate.now().plusDays(40))
        );

        members.stream()
               .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
               .forEach(m -> System.out.println(m.name + " membership expiring on " + m.expiryDate));
    }
}
