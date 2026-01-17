import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceChallenge {
    public static void main(String[] args) {

        // 1️⃣ StringBuilder vs StringBuffer
        int n = 1_000_000;
        String sample = "hello";

        // StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sample);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder time (ms): " + (endBuilder - startBuilder) / 1_000_000);

        // StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(sample);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer time (ms): " + (endBuffer - startBuffer) / 1_000_000);

        // 2️⃣ FileReader vs InputStreamReader
        String filePath = "C:\\Users\\alapu\\Desktop\\largefile.txt";

        // FileReader
        try {
            long startFileReader = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            BufferedReader br1 = new BufferedReader(fr);

            int wordCountFR = 0;
            String line;
            while ((line = br1.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountFR += words.length;
            }

            br1.close();
            fr.close();
            long endFileReader = System.nanoTime();

            System.out.println("FileReader word count: " + wordCountFR);
            System.out.println("FileReader time (ms): " + (endFileReader - startFileReader) / 1_000_000);

        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }

        // InputStreamReader
        try {
            long startISR = System.nanoTime();
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br2 = new BufferedReader(isr);

            int wordCountISR = 0;
            String line;
            while ((line = br2.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCountISR += words.length;
            }

            br2.close();
            isr.close();
            fis.close();
            long endISR = System.nanoTime();

            System.out.println("InputStreamReader word count: " + wordCountISR);
            System.out.println("InputStreamReader time (ms): " + (endISR - startISR) / 1_000_000);

        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
    }
}
