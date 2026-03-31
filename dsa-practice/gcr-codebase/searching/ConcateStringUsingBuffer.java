public class ConcateStringUsingBuffer {
    public static void main(String[] args) {

        String[] arr = {"Hello", " ", "World", "!", " Java"};

        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
