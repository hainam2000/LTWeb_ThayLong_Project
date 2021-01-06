package entity;

import database.ConnectionDB;
import model.Category;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class CategoryEntity {
    Statement s = null;
    PreparedStatement ps = null;
    ConnectionDB c = null;
    ResultSet rs = null;
    public List<Category> getAllCategory() {
        List<Category> clist = new LinkedList<>();
        try {
            s = ConnectionDB.connect();
            rs = s.executeQuery("SELECT * from Category");
            while(rs.next()){
                clist.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return clist;
    }
}
