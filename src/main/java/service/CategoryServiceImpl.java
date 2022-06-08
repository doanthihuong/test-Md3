package service;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thuchanhmd3?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from category");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categories.add(new Category(id,name));
            }
        } catch (SQLException e) {
        }
        return categories;

    }

    @Override
    public void add(Category category) throws SQLException {

    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt("id");
                String name = rs.getString("name");
                category = new Category(categoryId,name);
            }
        } catch (SQLException e) {
        }
        return category;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }

    @Override
    public List<Category> findAllOderByAge() {
        return null;
    }
}
