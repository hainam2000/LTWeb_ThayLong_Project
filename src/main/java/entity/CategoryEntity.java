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
            rs = s.executeQuery("SELECT * from Category order by id");
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
    public int getCountId(){
        Statement s = null;
        int result ;
        String query = "SELECT count(id)  from category";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query);

            if(rs.next()){
                return result = rs.getInt(1);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getIdByName(String name){
        Statement s = null;
        int result ;
        String query = "SELECT * from category WHERE name Like '"+name+"'";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query);

            if(rs.next()){
                return result = rs.getInt(1);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public Category getCategoryByID(String id) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from category where category.id = '" + id  +"'"  );
            while (rs.next()) {
                return new Category(
                        rs.getInt(1),
                        rs.getString(2));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    public void deleteCategory(String id){
        Statement s = null;
        String query = "delete from category where id = "+id;
        try{
            s = ConnectionDB.connect();
            s.execute(query);
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public int getMaxId(){
        Statement s = null;
        int result ;
        String query = "SELECT  MAX(id)  from category";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query);

            if(rs.next()){
                return result = rs.getInt(1);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addCategory(int id, String name){
        Statement s = null;
        String query = "INSERT INTO category VALUES ('"+id+"','"+name+"')" ;

        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public void editCategory(String id, String name){
        Statement s = null;
        String query ="UPDATE category SET  `name` ='"+name+"' where id = '"+id+"'" ;
        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
}
