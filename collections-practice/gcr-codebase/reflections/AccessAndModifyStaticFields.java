import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class AccessAndModifyStaticFields {
    public static void main(String[] args) throws Exception {

        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);

        System.out.println("Old Api key: " + f.get(null));
        f.set(null, "NEW_KEY");
        System.out.println("New Api key: " + f.get(null));
    }
}
