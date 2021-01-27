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
}
