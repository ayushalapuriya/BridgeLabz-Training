import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted");
    }
}

public class RoleBasedAccess {
    public static void main(String[] args) throws Exception {

        String currentRole = "USER"; // change to ADMIN

        Method m = AdminService.class.getDeclaredMethod("deleteUser");
        RoleAllowed r = m.getAnnotation(RoleAllowed.class);

        if (r.value().equals(currentRole))
            m.invoke(new AdminService());
        else
            System.out.println("Access Denied!");
    }
}
