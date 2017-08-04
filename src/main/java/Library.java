import java.io.PrintStream;

public class Library {

    private final PrintStream printstream;

    public Library(PrintStream printstream){
        this.printstream = printstream;
    }
    public void start() {
        printstream.println("Welcome to Biblioteca");
    }
}
