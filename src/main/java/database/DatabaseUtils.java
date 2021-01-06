package database;

import entity.CategoryEntity;
import model.Category;
import model.Product;
import entity.ProductEntity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) {
        ProductEntity pe = new ProductEntity();
        CategoryEntity ce = new CategoryEntity();
        Collection<Category> values = ce.getAllCategory();
        for (Category c : values) {
                System.out.println(c.toString());
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
