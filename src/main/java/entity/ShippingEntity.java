package entity;

import java.sql.*;

import database.ConnectionDB;
import model.*;
public class ShippingEntity {
    PreparedStatement ps = null;
    ResultSet rs = null;


    public Shipping getShippingByName(String name) {

        String sql = "select * from Shipping WHERE Shipping.`name` = ?;";
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if(rs.next()) {
                return new Shipping(rs.getString(2), rs.getInt(3));
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }
}
