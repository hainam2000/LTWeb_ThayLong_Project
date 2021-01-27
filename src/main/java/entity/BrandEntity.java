package entity;

import database.ConnectionDB;
import model.Brand;


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

    public List<Brand> getAllBrand() {
        List<Brand> blist = new LinkedList<>();
        try {
            s = ConnectionDB.connect();
            rs = s.executeQuery("SELECT * from Brand order by id");
            while(rs.next()){
                blist.add(new Brand(
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
    public Brand getBrandByID(String id) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from brand where brand.id = '" + id  +"'"  );
            while (rs.next()) {
                return new Brand(
                        rs.getInt(1),
                        rs.getString(2));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    public void deleteBrand(String id){
        Statement s = null;
        String query = "delete from brand where id = "+id;
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
        String query = "SELECT  MAX(id)  from brand";
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
    public void addBrand(int id, String name){
        Statement s = null;
        String query = "INSERT INTO brand VALUES ('"+id+"','"+name+"')" ;

        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public void editBrand(String id, String name){
        Statement s = null;
        String query ="UPDATE brand SET  `name` ='"+name+"' where id = '"+id+"'" ;
        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }

}
