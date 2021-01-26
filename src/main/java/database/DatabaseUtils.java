package database;

import model.*;
import entity.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) {
        ImageEntity ie = new ImageEntity();
        CategoryEntity ce = new CategoryEntity();
        ProductEntity pe = new ProductEntity();
        UserEntity ue = new UserEntity();
        OrderEntity oe = new OrderEntity();
        Order o = new Order();

        Product product = pe.getProductWithID("1");
        Cart c = new Cart();

        c.addProduct(pe.getProductWithID("1"));
        System.out.println(c.getTotalPrice());
        c.addProduct(pe.getProductWithID("1"));
        System.out.println(c.getTotalPrice());
        c.addProduct(pe.getProductWithID("1"));
        System.out.println(c.getTotalPrice());
        c.addProduct(pe.getProductWithID("1"));
        System.out.println(c.getTotalPrice());
        c.addProduct(pe.getProductWithID("1"));
        System.out.println(c.getTotalPrice());





        c.updateProduct("1", "2");


//        System.out.println(c.getTotalPrice());
//        c.updateProduct("1", );
//        System.out.println(c.getTotalQuantity());
//        oe.changeOrderStatus("2",c.getTotalPrice());
    }


    //Product(id, name, description, detail, price, isSale, priceSale, id_brand, storage)
    public void insertElement(String table, String values){
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            String query = "INSERT INTO " + table + " VALUES("
                    + values + ")";
            s.executeUpdate(query);
            System.out.println("all good");
        } catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }


}
