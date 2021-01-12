package entity;
import database.ConnectionDB;
import model.*;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ProductEntity {
    private final String query = "SELECT Product.id, Product.`name`, Product.description, Product.details, Image.url, Product.price, Product.isSale, Product.priceSale, Brand.`name`, Category.`name`, Product.`storage` from Product join Image on Product.id = Image.idProduct join Brand on Product.id_brand = Brand.id join Category on Category.id = Product.id_category AND Image.url LIKE '%/1.jpg'";
    public List<Product> getRandomProduct(String limit){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery( query + "ORDER BY RAND() limit " + limit);
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
            ResultSet rs = s.executeQuery(query + " WHERE Product.id_category = " + categoryID);
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
            ResultSet rs = s.executeQuery(query + " WHERE Product.id_category = " + brandID);
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
            ResultSet rs = s.executeQuery(query + " WHERE Product.id = " + id);
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

    public List<Product> searchProduct(String txtSearch){
        List<Product> result = new LinkedList<>();
        Statement s = null;

        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(query + "where (Product.`name` like '%" + txtSearch + "%' or  Brand.`name` like '%" + txtSearch + "%' or  Category.`name` like '%" + txtSearch + "%')");
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

    public List<Product> getRandomAll() {
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery( query + "ORDER BY RAND()");
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


    public List<Product> getProductForPagging(int limit, int index) {
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery( query + "ORDER BY RAND() LIMIT "+ limit + " OFFSET " + (index-1)*limit);
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
}
