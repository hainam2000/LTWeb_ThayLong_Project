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

    public List<Product> getAllProduct() {
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(query + "ORDER BY Product.id ASC ");
            while (rs.next()) {
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
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
    // delate Product
    public void deleteProduct(String id) {
        Statement s = null;
        String query1 = "delete from product where id = " + id;
        String query2 = "delete from image where idProduct = " + id;
        try {
            s = ConnectionDB.connect();
            s.execute(query1);
            s.execute(query2);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    // update Product
    public void editProduct(String id, String name, String description, String details, String price, String isSale, String salePrice,String brandName,String categoryName,String storage){
        Statement s = null;

        String query =" UPDATE product p JOIN category c ON p.id_category = c.id JOIN brand b ON p.id_brand = b.id "+ " SET p.`name`='"+name+"', p.description='"+description+"',p.details = '"+details+"', p.price='"+price+"', p.isSale='"+isSale+"', p.priceSale='"+salePrice+"',p.id_brand = (SELECT id FROM brand WHERE brand.NAME ='"+brandName+"'), p.id_category = (SELECT id FROM category WHERE category.NAME ='"+categoryName+"'),p.`storage` ='"+storage+"' WHERE p.id ='"+id+"'" ;
        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }

    public int getCountId(){
        Statement s = null;
        int result ;
        String query = "SELECT count(id)  from user";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query);

            if(rs.next()){
                return result = rs.getInt(1);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addProduct(int id, String name, String description, String details, String price, String isSale,String  priceSale, int  id_brand,int  id_category,String  storage){
        Statement s = null;

        String query = "INSERT INTO product VALUE ('"+id+"','"+name+"','"+description+"','"+details+"','"+price+"','"+isSale+"','"+priceSale+"','"+id_brand+"','"+id_category+"','"+storage+"')" ;

        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }

    public int getMaxId(){
        Statement s = null;
        int result ;
        String query = "SELECT MAX(id)  from product";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query);

            if(rs.next()){
                return result = rs.getInt(1);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
