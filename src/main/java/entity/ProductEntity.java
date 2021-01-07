package entity;
import database.ConnectionDB;
import model.Product;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ProductEntity {
    private final String query = "SELECT Product.id, Product.`name`, Product.description, Product.details, Image.url, Product.price, Product.isSale, Product.priceSale, Brand.`name`, Category.`name`, Product.`storage` from Product join Image on Product.id = Image.idProduct join Brand on Product.id_brand = Brand.id join Category on Category.id = Product.id_category ";
    public List<Product> getRandomProduct(String limit){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery( query + "AND Image.url LIKE '%/1.jpg' ORDER BY RAND() limit " + limit);
            while(rs.next()){
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> getAllProductByCategoryID(String categoryID){
        List<Product> result = new LinkedList<>();
        Statement s = null;

        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(query + " WHERE Product.id_category = " + categoryID + " AND Image.url LIKE '%/1.jpg';");
            while(rs.next()) {
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }
            return result;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    public List<Product> getAllProductByBrandID(String brandID) {
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(query + " WHERE Product.id_category = " + brandID + " AND Image.url LIKE '%/1';");
            while(rs.next()) {
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11)));
            }
            return result;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    public Product getProductWithID(String id) {
        Statement s = null;
        Product p = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(query + " WHERE Product.id = " + id + " AND Image.url LIKE '%/1.jpg';");
            while(rs.next()){
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11));
            }
            return p;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
