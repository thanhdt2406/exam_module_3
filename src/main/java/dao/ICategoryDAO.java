package dao;

import model.Category;

import java.util.List;

public interface ICategoryDAO {
    Category getCategoryByID(int categoryID);

    List<Category> getAllCategory();
}
