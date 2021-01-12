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
    public int getNumberPageWithCate(String id_category){
        int pages = 0;
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(  "select count(*) from product where Product.id_category = " + id_category);
            while(rs.next()){
                int total = rs.getInt(1);
                pages = total / 20;
                if(total % 20 != 0) {
                    pages++;
                }
            }
            return pages;
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
