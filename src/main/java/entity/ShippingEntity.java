package entity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import database.ConnectionDB;
import model.*;
public class ShippingEntity {
    PreparedStatement ps = null;
    ResultSet rs = null;


    public Shipping getShippingByName(String type) {

        String sql = "select * from Shipping WHERE Shipping.`type` = ?;";
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new Shipping(rs.getString(2), rs.getString(3), rs.getInt(4));
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Shipping> getAllShipping() {
        List<Shipping> result = new LinkedList<>();
        String sql = "select * from Shipping";
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                result.add( new Shipping(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Shipping> getAllShippingForManager() {
        List<Shipping> sList = new LinkedList<>();
        try {
            s = ConnectionDB.connect();
            rs = s.executeQuery("SELECT * from shipping order by id");
            while(rs.next()){
                sList.add(new Shipping(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return sList;
    }
    public Shipping getShippingByID(String id) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from shipping where shipping.id = '" + id  +"'"  );
            while (rs.next()) {
                return new Shipping(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    public void deleteShipping(String id){
        Statement s = null;
        String query = "delete from shipping where id = "+id;
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
        String query = "SELECT  MAX(id)  from shipping";
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
    public void addShipping(int id, String name,String type,String price){
        Statement s = null;
        String query = "INSERT INTO shipping VALUES ('"+id+"','"+name+"','"+type+"','"+price+"')" ;

        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public void editShipping(String id, String name,String type,String price){
        Statement s = null;
        String query ="UPDATE shipping SET  `name` ='"+name+"',price='"+price+"', type ='"+type+"' where id = '"+id+"'" ;
        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
}
