package app;

import logger.Logger;
import catalog.LibraryCatalog;
import factory.UserFactory;
import model.Book;
import observer.User;
import strategy.FacultyReservation;
import strategy.StudentReservation;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");

        student.showRole();
        faculty.showRole();

        catalog.addObserver(student);
        catalog.addObserver(faculty);

        Book book = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd Edition")
                .genre("Software Engineering")
                .build();

        catalog.addBook(book);
        
        student.setReservationStrategy(new StudentReservation());
        faculty.setReservationStrategy(new FacultyReservation());

        student.reserve("Design Patterns");
        faculty.reserve("Clean Code");
        
        Logger logger = Logger.getInstance();
        logger.log("New book added to catalog");


    }
}
