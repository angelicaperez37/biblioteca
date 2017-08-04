import java.io.PrintStream;
import java.util.ArrayList;

public class Library {

    private final PrintStream printStream;
    private ArrayList<Book> listOfBooks;

    public Library(PrintStream printstream, ArrayList<Book> listOfBooks){
        this.printStream = printstream;
        this.listOfBooks = listOfBooks;
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
                books+= book.toString() + ", ";
        }

        printStream.println(books);
    }
}
