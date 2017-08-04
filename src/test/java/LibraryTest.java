import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void testStartPrintsWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream);
        library.start();
        verify(printStream).println("Welcome to Biblioteca");
    }
    
    @Test
    public void shouldPrintListOfBooks() {
        PrintStream printStream = mock(PrintStream.class);
        Library library = new Library(printStream);
        library.printListOfBooks();
        verify(printStream).println("Harry Potter, Black Swan, The Bible");
        
    }

}