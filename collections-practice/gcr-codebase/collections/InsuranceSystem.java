import java.util.*;

class Policy {
    int number; String name;
    Policy(int n,String nm){number=n;name=nm;}
}

public class InsuranceSystem {
    public static void main(String[] args) {
        Map<Integer,Policy> map = new HashMap<>();
        map.put(101,new Policy(101,"John"));
        map.put(102,new Policy(102,"Alice"));

        map.forEach((k,v)->System.out.println(k+" → "+v.name));
    }
}
