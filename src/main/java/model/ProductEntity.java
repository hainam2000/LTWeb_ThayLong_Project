package model;
import database.ConnectionDB;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ProductEntity {
    public List<Product> getAllProductWithCategory(String table, String category){
        List<Product> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from " + table + " where id_category =" + category);
            while(rs.next()) {
                result.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
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
