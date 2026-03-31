public class User {

    private CinemaManager manager;

    public User(CinemaManager manager) {
        this.manager = manager;
    }

    public void addMovie(String title, String time) {
        try {
            manager.addMovie(title, time);
            System.out.println("Movie added successfully.");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchMovie(String keyword) {
        manager.searchMovie(keyword);
    }

    public void displayMovies() {
        manager.displayAllMovies();
    }
}
