import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void testStartPrintsWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream, new ArrayList<Book>());
        library.start();
        verify(printStream).println("Welcome to Biblioteca");
    }
    
    @Test
    public void shouldPrintListOfBooks() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> listOfBooks = new ArrayList();
        listOfBooks.add(new Book("Harry Potter"));
        listOfBooks.add(new Book("Black Swan"));
        listOfBooks.add(new Book("The Bible"));

        Library library = new Library(printStream, listOfBooks);

        library.printListOfBooks();
        verify(printStream).println("Harry Potter, Black Swan, The Bible");
        
    }

}