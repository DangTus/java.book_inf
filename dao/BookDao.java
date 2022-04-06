package book.dao;

import book.model.Book;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
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
        
        String sql = "SELECT * FROM book_inf WHERE title like '%" + title + "%'";
        
        PreparedStatement preparedStatement = con.prepareStatement(sql);     
        
        ResultSet rs = preparedStatement.executeQuery();
        
        while(rs.next()) {
            Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price"));
            books.add(book);
        }
        
        return books;
    }
}
