import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private PrintStream printStream;
    private Library library;
    ArrayList<Book> listOfBooks;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        listOfBooks = new ArrayList();
        library = new Library(printStream, listOfBooks);
    }

    @Test
    public void testStartPrintsWelcomeMessage() {
        library.start();
        verify(printStream).println("Welcome to Biblioteca");
    }
    
    @Test
    public void shouldPrintListOfBooks() {
        listOfBooks.add(new Book("Harry Potter"));
        listOfBooks.add(new Book("Black Swan"));
        listOfBooks.add(new Book("The Bible"));
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\t\t\nBlack Swan\t\t\nThe Bible\t\t");
    }

    @Test
    public void shouldContainsAuthorNameWhenPrintingList() {
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling"));
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t");
    }


    @Test
    public void shouldContainAuthorAndPublishYearWhenPrintingList() {
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }
}