
public class StringConcatTest {

    public static void main(String[] args) {

        int n = 100000;

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        System.out.println("String Time: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        System.out.println("StringBuilder Time: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        System.out.println("StringBuffer Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
