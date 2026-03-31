import java.io.*;

public class BufferedVsUnbuffered {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) throws IOException {
        copyUnbuffered("bigfile.dat", "unbuffered.dat");
        copyBuffered("bigfile.dat", "buffered.dat");
    }

    static void copyUnbuffered(String src, String dest) throws IOException {
        long start = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        long end = System.nanoTime();
        System.out.println("Unbuffered Time: " + (end - start) + " ns");
    }

    static void copyBuffered(String src, String dest) throws IOException {
        long start = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }

        long end = System.nanoTime();
        System.out.println("Buffered Time: " + (end - start) + " ns");
    }
}
