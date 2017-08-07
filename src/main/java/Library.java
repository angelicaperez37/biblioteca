import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private final PrintStream printStream;
    private Scanner scanner;
    private ArrayList<Book> listOfBooks;

    public Library(PrintStream printstream, ArrayList<Book> listOfBooks, Scanner scanner){
        this.printStream = printstream;
        this.listOfBooks = listOfBooks;
        this.scanner = scanner;
    }
    public void start() {
        printStream.println("Welcome to Biblioteca");
    }

    public void printListOfBooks() {
        String books = "";
        for (Book book: listOfBooks){
            if(listOfBooks.indexOf(book) == listOfBooks.size()-1) {
                books += book.toString();
            }
            else
                books+= book.toString() + "\n";
        }

        printStream.println(books);
    }

    public void printMenuOptions() {
        printStream.println("Pick an option:\n1) List books");
    }

    public void selectMenuOption(String s) {
        if (s.equals("1")) {
            printListOfBooks();
        }
    }

    public void getUserInput() {
        selectMenuOption(scanner.nextLine());
    }
}
