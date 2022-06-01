package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    CategoryService categoryService =new CategoryServiceImpl();
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
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");

                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                String description = rs.getString("description");
                Category category = categoryService.findById(categoryId);
                products.add(new Product(id, name, price, quantity,color, description, category));
            }
        } catch (SQLException e) {
        }

        return products;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findAllOderByAge() {
        return null;
    }
}
