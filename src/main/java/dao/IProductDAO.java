package dao;

import model.Product;

import java.util.List;

public interface IProductDAO {
    boolean addNewProduct(String productName, int price, String color, String description, int categoryID, int amount);

    List<Product> getAllProduct();

    boolean editProduct(int productID, String productName, int price, String color, String description, int categoryID, int amount);

    boolean deleteProduct(int productID);

    Product getProductByID(int productID);

    List<Product> getProductByName(String productName);

}
