package database;

import model.*;
import entity.*;
import tools.MailUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) throws Exception {
        ImageEntity ie = new ImageEntity();
        CategoryEntity ce = new CategoryEntity();
        ProductEntity pe = new ProductEntity();
        UserEntity ue = new UserEntity();
        OrderEntity oe = new OrderEntity();
        ShippingEntity se = new ShippingEntity();

        List<Order> order = oe.getAllOrderByUserID("1");

        for(Order o : order) {
            System.out.println(o.toString());
        }

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
