package book.dao;

import book.model.Book;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public List<Book> getAllBook() throws SQLException {
        List<Book> books = new ArrayList<Book>();
        
        Connection con = JDBCConnection.getJDBCConection();
        
        String sql = "SELECT * FROM book_inf";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        
        ResultSet rs = preparedStatement.executeQuery();
        
        while(rs.next()) {
            Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
            books.add(book);
        }
        
        return books;
    }
    
    public List<Book> getBookByTitle(String title) throws SQLException {
        List<Book> books = new ArrayList<Book>();
        
        Connection con = JDBCConnection.getJDBCConection();
        
        Statement stm = con.createStatement();
        
        String sql = "SELECT * FROM book_inf WHERE title like '%" + title + "%'";
        
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
            books.add(book);
        }
        
        return books;
    }
    
    public List<Integer> getAllId() throws SQLException {
        List<Integer> ids = new ArrayList<Integer>();
        
        Connection con = JDBCConnection.getJDBCConection();
        
        Statement stm = con.createStatement();
        
        String sql = "SELECT id FROM book_inf";
        
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()) {
            int id = rs.getInt("id");
            ids.add(id);
        }
        
        return ids;
    }
    
    public Book getBookById(int id) throws SQLException {
        Connection con = JDBCConnection.getJDBCConection();        
        
        String sql = "SELECT * FROM book_inf WHERE id = ?";
        
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, id);
        
        ResultSet rs = pstm.executeQuery();
        
        rs.next();
        Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
        
        return book;
    }
    
    public int addBook(Book book) throws SQLException {
        Connection con = JDBCConnection.getJDBCConection();
        
        String sql = "INSERT INTO book_inf(title, price) "
                + "VALUES(?, ?)";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setDouble(2, book.getPrice());
        
        int rs = preparedStatement.executeUpdate();
        
        return rs;
    }
    
    public int updateBook(Book book) throws SQLException {
        Connection con = JDBCConnection.getJDBCConection();
        
        String sql = "UPDATE book_inf "
                + "SET title = ?, price = ? "
                + "WHERE id = ?";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);        
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setDouble(2, book.getPrice());
        preparedStatement.setInt(3, book.getId());
        
        int rs = preparedStatement.executeUpdate();
        
        return rs;
    }
    
    public int deleteBook(int id) throws SQLException {
        Connection con = JDBCConnection.getJDBCConection();
        
        String sql = "DELETE FROM book_inf "
                + "WHERE id = ?";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        int rs = preparedStatement.executeUpdate();
        
        return rs;
    }
}
