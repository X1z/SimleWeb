package database.dao;

import database.connection.DBWork;
import database.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by X1z on 22.02.2016.
 */
public class BookDao {
    private final DBWork dbWork = DBWork.getInstance();
    private final String QUERY_INSERT_BOOK="insert into books (name , tel, age) VALUES (?,?,?)";
    private final String QUERY_DELETE_BOOK="delete from books where id=?";
    private final String QUERY_DELETE_BOOK_BY_NAME="delete from books where name=?";

    public BookDao() {
    }

    public void insertBook(Book book){
        try (Connection connection = dbWork.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_BOOK))
        {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2,book.getAutor());
            preparedStatement.setInt(3, book.getCount());
            System.out.println(preparedStatement.execute());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookById(int bookId){
        try(Connection connection = dbWork.getConnection();
            PreparedStatement preparedStatement = dbWork.getConnection().prepareStatement(QUERY_DELETE_BOOK))
        {
            preparedStatement.setInt(1,bookId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookByName(String bookName){
        try (Connection connection = dbWork.getConnection();
             PreparedStatement preparedStatement = dbWork.getConnection().prepareStatement(QUERY_DELETE_BOOK_BY_NAME))
        {
            preparedStatement.setString(1, bookName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
