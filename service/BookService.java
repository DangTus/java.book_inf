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

    public Book getBookById(int id) throws SQLException {
        return bookDao.getBookById(id);
    }

    public List<Integer> getAllId() throws SQLException {
        return bookDao.getAllId();
    }

    public int addBook(Book book) throws SQLException {
        return bookDao.addBook(book);
    }

    public int updateBook(Book book) throws SQLException {
        return bookDao.updateBook(book);
    }

    public int deleteBook(int id) throws SQLException {
        return bookDao.deleteBook(id);
    }
}
