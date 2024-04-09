import book.Book;
import book.BookRepository;
import book.BookService;
import book.InMemoryBookRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        BookService bookService = new BookService(bookRepository);
        Book searchBook = bookService.findBookById("1");
        List<Book> books = bookService.findAllBooks();
        System.out.println(searchBook);
        System.out.println(books);
    }
}