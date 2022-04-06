package book.service;

import book.dao.BookDao;
import book.model.Book;
import java.sql.SQLException;
import java.util.List;

public class BookService {

    BookDao bookDao = null;

    public BookService() {
        bookDao = new BookDao();
    }
    
    public List<Book> getAllBook() throws SQLException {
        return bookDao.getAllBook();
    }
    
    public List<Book> getBookByTitle(String title) throws SQLException {
        return bookDao.getBookByTitle(title);
    }
}
