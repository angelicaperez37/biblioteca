import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainTest {



    @Test
    public void shouldPrintMessagesWhenMainRuns() {
        String[] args = null;
        Main.main(args);
        Library libraryMock = mock(Library.class);

        libraryMock.start();
        libraryMock.printListOfBooks();

        InOrder mainOrder = inOrder(libraryMock);

        mainOrder.verify(libraryMock).start();
        mainOrder.verify(libraryMock).printListOfBooks();
    }

}