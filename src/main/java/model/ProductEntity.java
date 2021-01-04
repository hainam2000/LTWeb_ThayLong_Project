package model;
import database.ConnectionDB;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ProductEntity {

    public List<Product> getRandomProduct(String limit){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT * from Product JOIN Image on Image.idProduct = Product.id  AND Image.url LIKE '%/1' ORDER BY RAND() limit " + limit);
            while(rs.next()){
                result.add(new Product(
//  int id, String name, String description, String details,
//  String imgUrl, int price, int isSale,
//  int salePrice, int id_brand, int id_category, int storage)
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(13),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> getRandomProductWithCate(String limit, String cate){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT * from Product JOIN Image on Image.idProduct = Product.id WHERE Product.id = " + cate + " AND Image.url LIKE '%/1' ORDER BY RAND() limit " + limit);
            while(rs.next()){
                result.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(13),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> getAllProductForHomepage(String category) {
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT * from Product JOIN Image on Image.idProduct = Product.id WHERE Product.id_category = "+ category +" AND Image.url LIKE '%/1';");
            while(rs.next()){
                result.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(13),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Product> getAllProductWithCategory(String table, String category){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT * from Product JOIN Image on Image.idProduct = Product.id WHERE Product.id_category =" + category);
            while(rs.next()) {
                result.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(13),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10)));
            }
            return result;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return result;
        }
    }
}
