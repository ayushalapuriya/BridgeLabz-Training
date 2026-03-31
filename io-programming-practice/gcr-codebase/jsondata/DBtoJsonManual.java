
public class DBtoJsonManual {
    static class User {
        String name;
        int age;
        String email;
        User(String name, int age, String email){
            this.name = name;
            this.age = age;
            this.email = email;
        }
    }

    public static void main(String[] args){
        // Simulated DB records
        User[] users = {
            new User("Amit",22,"amit@gmail.com"),
            new User("Rohit",30,"rohit@gmail.com"),
            new User("Sita",28,"sita@gmail.com")
        };

        System.out.println("[");
        for(int i=0; i<users.length; i++){
            User u = users[i];
            System.out.print("  {\"name\":\""+u.name+"\",\"age\":"+u.age+",\"email\":\""+u.email+"\"}");
            if(i<users.length-1) System.out.println(",");
        }
        System.out.println("\n]");
    }
}
