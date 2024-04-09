import book.Book;
import book.BookRepository;
import book.BookService;
import book.InMemoryBookRepository;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TestBookService {
    @Test
    public void testBookServiceSearch() {

        BookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findById(anyString())).thenReturn(new Book("5", "Tales", "Anderson"));

        BookService bookService = new BookService(bookRepository);
        bookService.findBookById("1");
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testBookServiceAllBooks() {

        BookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(new Book("5", "Tales1", "Anderson"), new Book("2", "Tales2", "Grimm")));

        BookService bookService = new BookService(bookRepository);
        List<Book> resultSize = bookService.findAllBooks();
        assertEquals(2, resultSize.size());
    }
}
