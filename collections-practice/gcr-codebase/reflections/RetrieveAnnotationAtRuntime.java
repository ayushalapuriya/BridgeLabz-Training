import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Ayush")
class Demo { }

public class RetrieveAnnotationAtRuntime {
    public static void main(String[] args) {

        Author a = Demo.class.getAnnotation(Author.class);
        System.out.println("Author name: " + a.name());
    }
}
