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
        verify(printStream).println("Harry Potter\t\t\nBlack Swan\t\t\nThe Bible\t\t");
        
    }

    @Test
    public void shouldContainsAuthorNameWhenPrintingList() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> listOfBooks = new ArrayList();
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling"));
        Library library = new Library(printStream, listOfBooks);
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t");
    }


    @Test
    public void shouldContainAuthorAndPublishYearWhenPrintingList() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> listOfBooks = new ArrayList();
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        Library library = new Library(printStream, listOfBooks);
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }
}