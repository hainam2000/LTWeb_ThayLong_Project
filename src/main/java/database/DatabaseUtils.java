package database;

import model.Image;
import model.ImageEntity;
import model.Product;
import model.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Statement s = ConnectionDB.connect();
        DatabaseUtils DU = new DatabaseUtils();
        ProductEntity pe = new ProductEntity();
        ImageEntity ie = new ImageEntity();
        int count = 0;
        for(Image i : ie.getAllImageWithProductID("2")){
            if(count == 10){
                break;
            } else {
                System.out.println("id: " + i.getId());
                System.out.println("id product: " + i.getIdProduct());
                System.out.println("url: " + i.getUrl());
            }
            count++;
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
