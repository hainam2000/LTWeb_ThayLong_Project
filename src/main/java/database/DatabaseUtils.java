package database;

import entity.CategoryEntity;
import entity.ImageEntity;
import model.Category;
import model.Image;
import model.Product;
import entity.ProductEntity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) {
        ImageEntity ie = new ImageEntity();
        CategoryEntity ce = new CategoryEntity();
        ProductEntity pe = new ProductEntity();

        Collection<Product> products = pe.getRandomProduct("40");
        Collection<Image> images = ie.getAllImageWithProductID("1");
//        Product p = pe.getProductWithID("1");
        for (Product p : products) {
            System.out.println(p.toString());
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
