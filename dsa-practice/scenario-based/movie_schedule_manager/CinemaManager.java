import java.util.ArrayList;
import java.util.List;

public class CinemaManager {

    private List<String> movieTitles;
    private List<String> showTimes;

    public CinemaManager() {
        movieTitles = new ArrayList<>();
        showTimes = new ArrayList<>();
    }

    // Validate time in HH:MM format
    private void validateTime(String time) throws InvalidTimeFormatException {
        try {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                throw new InvalidTimeFormatException("Invalid time format: " + time);
            }
        } catch (Exception e) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTime(time);
        movieTitles.add(title);
        showTimes.add(time);
    }

    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("%d. %s at %s", i + 1, movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    public void searchMovie(String keyword) {
        boolean found = false;

        try {
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(
                        movieTitles.get(i) + " at " + showTimes.get(i)
                    );
                    found = true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Search error: Invalid index accessed.");
        }

        if (!found) {
            System.out.println("No movie found with keyword: " + keyword);
        }
    }

    // Convert List to Array for reports
    public String[] generateReport() {
        String[] report = new String[movieTitles.size()];

        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = movieTitles.get(i) + " - " + showTimes.get(i);
        }

        return report;
    }
}
