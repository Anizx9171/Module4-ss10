package model.dao.category;

import model.entity.Category;
import util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectDB.openDB();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("ID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeDB(connection);
        }
        return categories;
    }

    @Override
    public boolean saveOrUpdate(Category category, Integer integer) {
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Category> findByName(String name) {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectDB.openDB();
            String sql = "SELECT * FROM category where name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("ID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeDB(connection);
        }
        return categories;
    }

    @Override
    public List<Category> sortAZ() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectDB.openDB();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM category ORDER BY name");
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Category category = new Category(resultSet.getInt("ID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeDB(connection);
        }
        return categories;
    }
}
