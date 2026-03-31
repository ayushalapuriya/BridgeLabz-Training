public class LinearSearchWord {
    public static String searchWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Hello world",
            "Java is fun",
            "Linear search example"
        };
        String result = searchWord(sentences, "Java");
        System.out.println("Sentence containing word: " + result);
    }
}
