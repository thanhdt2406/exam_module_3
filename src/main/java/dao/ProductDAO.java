package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    @Override
    public boolean addNewProduct(String productName, int price, String color, String description, int categoryID, int amount) {
        Connection connection = ConnectDB.getConnect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product (productName, price, color, description, categoryID, amount) VALUES (?,?,?,?,?,?);");
            preparedStatement.setString(1,productName);
            preparedStatement.setInt(2,price);
            preparedStatement.setString(3,color);
            preparedStatement.setString(4,description);
            preparedStatement.setInt(5,categoryID);
            preparedStatement.setInt(6,amount);
            if(preparedStatement.executeUpdate()!=0){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllProduct() {
        Connection connection = ConnectDB.getConnect();
        List<Product> productList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product;");
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryID = rs.getInt("categoryID");
                ICategoryDAO categoryDAO = new CategoryDAO();
                Category category = categoryDAO.getCategoryByID(categoryID);
                Product product = new Product(productID, productName, price, amount, color, description, category);
                productList.add(product);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean editProduct(int productID, String productName, int price, String color, String description, int categoryID, int amount) {
        Connection connection = ConnectDB.getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set productName = ?, price = ?, color=?,description=?,categoryID=?,amount=? where productID=?;");
            preparedStatement.setString(1, productName);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, color);
            preparedStatement.setString(4, description);
            preparedStatement.setInt(5, categoryID);
            preparedStatement.setInt(6, amount);
            preparedStatement.setInt(7, productID);
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productID) {
        Connection connection = ConnectDB.getConnect();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where productID =?;");
            preparedStatement.setInt(1,productID);
            if(preparedStatement.executeUpdate()!=0){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProductByID(int productID) {
        Connection connection = ConnectDB.getConnect();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where productID = ?;");
            preparedStatement.setInt(1,productID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("productName");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryID = rs.getInt("categoryID");
                ICategoryDAO categoryDAO = new CategoryDAO();
                Category category = categoryDAO.getCategoryByID(categoryID);
                product = new Product(productID, productName, price, amount, color, description, category);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getProductByName(String productName) {
        Connection connection = ConnectDB.getConnect();
        List<Product> products = new ArrayList<>();
        productName = "%"+productName+"%";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where productName like ?;");
            preparedStatement.setString(1,productName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                int price = rs.getInt("price");
                String name = rs.getString("productName");
                int amount = rs.getInt("amount");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryID = rs.getInt("categoryID");
                ICategoryDAO categoryDAO = new CategoryDAO();
                Category category = categoryDAO.getCategoryByID(categoryID);
                products.add(new Product(productID, name, price, amount, color, description, category));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }
}
