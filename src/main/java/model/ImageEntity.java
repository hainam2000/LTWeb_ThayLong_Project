package model;

import database.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ImageEntity {
    public List<Image> getAllImageWithProductID( String productID){
        List<Image> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT * from Image INNER JOIN Product ON Image.idProduct = Product.id WHERE Product.id = " + productID);
            while(rs.next()) {
                result.add(new Image(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
            return result;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return result;
        }
    }
}
