import java.io.PrintStream;

public class Library {

    private final PrintStream printStream;

    public Library(PrintStream printstream){
        this.printStream = printstream;
    }
    public void start() {
        printStream.println("Welcome to Biblioteca");
    }

    public void printListOfBooks() {
        printStream.println("Harry Potter, Black Swan, The Bible");
    }
}
