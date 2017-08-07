import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private PrintStream printStream;
    private Library library;
    ArrayList<Book> listOfBooks;
    Scanner scanner;


    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        scanner = new Scanner(System.in);
        listOfBooks = new ArrayList();
        library = new Library(printStream, listOfBooks, scanner);
    }

    private void setupInput (String desiredInput) {
        System.setIn(new ByteArrayInputStream(desiredInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        library = new Library(printStream, listOfBooks, scanner);
    }

    @Test
    @Ignore
    public void shouldPrintMessagesWhenMainRuns() {
        library.start();
        library.chooseFromMenuOptions();

        InOrder mainOrder = inOrder(library);

        mainOrder.verify(library).start();
        mainOrder.verify(library).chooseFromMenuOptions();
    }

    @Test
    public void testStartPrintsWelcomeMessage() {
        library.start();
        verify(printStream).println("Welcome to Biblioteca");
    }
    
    @Test
    public void shouldPrintListOfBooks() {
        listOfBooks.add(new Book("Harry Potter", null, null));
        listOfBooks.add(new Book("Black Swan", null, null));
        listOfBooks.add(new Book("The Bible", null, null));
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tnull\tnull\nBlack Swan\tnull\tnull\nThe Bible\tnull\tnull");
    }

    @Test
    public void shouldContainsAuthorNameWhenPrintingList() {
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", null));
        library.printListOfBooks();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\tnull");
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
        setupInput("1");
        library.chooseFromMenuOptions();
        verify(printStream).println("Pick an option:\n1) List books");
    }

    @Test
    public void shouldPrintBookListWhenThatOptionIsSelected() throws Exception {
        setupInput("1");
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library.chooseFromMenuOptions();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }

    @Test
    public void shouldSelectOptionAccordingToUserInput() throws Exception {
        setupInput("1");
        listOfBooks.add(new Book("Harry Potter", "J.K. Rowling", "2000"));
        library.getUserInput();
        verify(printStream).println("Harry Potter\tJ.K. Rowling\t2000");
    }
}