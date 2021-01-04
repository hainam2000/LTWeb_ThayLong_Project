package database;

import model.Product;
import model.ProductEntity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) {
        ProductEntity pe = new ProductEntity();
        Collection<Product> values = pe.getRandomProduct("20");
        for (Product p : values) {
                System.out.println(p.getName());
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
