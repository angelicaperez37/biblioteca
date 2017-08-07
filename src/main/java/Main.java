import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static PrintStream printStream;
    private static ArrayList<Book> listOfBooks;
    private static Library library;

    public static void main(String[] args) {
        printStream = new PrintStream(System.out);
        listOfBooks = new ArrayList();
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library = new Library(printStream, listOfBooks, new Scanner(System.in));
        library.start();
        library.chooseFromMenuOptions();
    }
}
