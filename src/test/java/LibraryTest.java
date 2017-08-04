import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private PrintStream printStream;
    private Library library;
    ArrayList<Book> listOfBooks;
    Scanner scanner;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
//        scanner = mock(Scanner.class);
        scanner = new Scanner(System.in);//Bad!!! only temporary because we can't mock Scanner (yet?)
        listOfBooks = new ArrayList();
        library = new Library(printStream, listOfBooks, scanner);
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

    @Test
    public void shouldPrintListOfMultipleBooksWithDetails() throws Exception {
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        listOfBooks.add(new Book("Black Swan", "Joe Schmoe", "1999"));
        library.printListOfBooks();

        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000\nBlack Swan\tJoe Schmoe\t1999");
    }

    @Test
    public void shouldPrintMenuOptionsWhenApplicationStarts() throws Exception {
        library.printMenuOptions();
        verify(printStream).println("Pick an option:\n1) List books");
    }

    @Test
    public void shouldPrintBookListWhenThatOptionIsSelected() throws Exception {
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library.selectMenuOption("1");
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }

    @Test
    @Ignore
    public void shouldSelectOptionAccordingToUserInput() throws Exception {
        when(scanner.nextLine()).thenReturn("1");
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library.getUserInput();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }
}