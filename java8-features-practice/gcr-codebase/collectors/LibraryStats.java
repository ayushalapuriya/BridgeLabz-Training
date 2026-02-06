import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String genre;
    int pages;
    Book(String t, String g, int p) { title = t; genre = g; pages = p; }

    public String getGenre() { return genre; }
    public int getPages() { return pages; }
}

public class LibraryStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Fiction", 200),
            new Book("Book B", "Non-Fiction", 300),
            new Book("Book C", "Fiction", 150),
            new Book("Book D", "Non-Fiction", 400)
        );

        Map<String, IntSummaryStatistics> statsByGenre = books.stream()
            .collect(Collectors.groupingBy(
                Book::getGenre,
                Collectors.summarizingInt(Book::getPages)
            ));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println(genre + " -> Total: " + stats.getSum() +
                               ", Avg: " + stats.getAverage() +
                               ", Max: " + stats.getMax());
        });
    }
}
