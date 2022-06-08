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

             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where price>200");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                Category category = categoryService.findById(categoryId);
                products.add(new Product(id, name, price, quantity,color, description, category));
            }
        } catch (SQLException e) {
        }
        return products;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection =getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into thuchanhmd3.product(id,name,price,quantity,color,description,categoryId)values (?,?,?,?,?,?,?)");) {
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setInt(7,product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    @Override
    public Product findById(int id) {
        Product product = new Product();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idp = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                Category category =categoryService.findById(categoryId);
                product =new Product(id,name,price,quantity,color,category);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id =?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
