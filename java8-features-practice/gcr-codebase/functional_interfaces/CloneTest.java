class Prototype implements Cloneable {
    String name;
    Prototype(String name) { this.name = name; }
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype original = new Prototype("Original");
        Prototype copy = original.clone();
        System.out.println("Original: " + original.name + ", Copy: " + copy.name);
    }
}
