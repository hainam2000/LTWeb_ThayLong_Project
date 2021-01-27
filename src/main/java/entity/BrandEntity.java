package entity;

import database.ConnectionDB;
import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class BrandEntity {
    Statement s = null;
    PreparedStatement ps = null;
    ConnectionDB c = null;
    ResultSet rs = null;
    public List<Category> getAllBrand() {
        List<Category> blist = new LinkedList<>();
        try {
            s = ConnectionDB.connect();
            rs = s.executeQuery("SELECT * from Brand");
            while(rs.next()){
                blist.add(new Category(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return blist;
    }

    public int getCountId(){
        Statement s = null;
        int result ;
        String query = "SELECT count(id)  from brand";
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
        String query = "SELECT * from brand WHERE name Like '"+name+"'";
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



}
