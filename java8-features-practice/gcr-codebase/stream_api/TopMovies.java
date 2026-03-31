import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int releaseYear;

    Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 9.1, 2023),
            new Movie("Movie B", 8.5, 2022),
            new Movie("Movie C", 9.3, 2023),
            new Movie("Movie D", 7.9, 2021),
            new Movie("Movie E", 8.8, 2022),
            new Movie("Movie F", 9.0, 2023)
        );

        movies.stream()
              .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                      .thenComparing(Movie::getReleaseYear).reversed())
              .limit(5)
              .forEach(m -> System.out.println(m.title + " - " + m.rating + " (" + m.releaseYear + ")"));
    }
}
