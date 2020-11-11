package dao;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    @Override
    public Category getCategoryByID(int categoryID) {
        Connection connection = ConnectDB.getConnect();
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where categoryID = ?;");
            preparedStatement.setInt(1,categoryID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String categoryName = rs.getString("categoryName");
                category = new Category(categoryID,categoryName);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        Connection connection = ConnectDB.getConnect();
        List<Category> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from category;");
            while (rs.next()){
                int categoryID = rs.getInt("categoryID");
                String categoryName = rs.getString("categoryName");
                Category category = new Category(categoryID,categoryName);
                categories.add(category);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return categories;
    }
}
