public class Main {

    public static void main(String[] args) {

        CinemaManager manager = new CinemaManager();
        User user = new User(manager);

        user.addMovie("Inception", "18:30");
        user.addMovie("Interstellar", "21:00");
        user.addMovie("Avatar", "25:99"); // Invalid time

        System.out.println("\nAll Movies:");
        user.displayMovies();

        System.out.println("\nSearch Results:");
        user.searchMovie("Inter");

        System.out.println("\nPrintable Report:");
        String[] report = manager.generateReport();
        for (String entry : report) {
            System.out.println(entry);
        }
    }
}
