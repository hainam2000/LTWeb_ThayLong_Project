package entity;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import database.ConnectionDB;
public class UserEntity {

    public User getUser(String username, String password) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from user where user.username = '" + username + "' and user.password = '" + password + "'" );
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
    public User getUserByID(String id) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from user where user.id = '" + id  +"'"  );
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public User checkExist(String username, String mail) {
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("select * from user where user.username = '" + username + "' or user.mail = '" + mail + "'" );
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void register(String username, String password, String mail) {
        Statement s = null;
        String query = "insert into User values (user.id, '', '" + mail +"', '', '', 2, '" + username + "', '" + password +"')";
        try {
            s = ConnectionDB.connect();
            s.executeUpdate(query);
            ResultSet rs = s.executeQuery("select `User`.id from `User` where `User`.username = '" + username +"'");
            while(rs.next()) {
                OrderEntity.createOrder(rs.getString(1));
            }
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(String id, String fullName, String email, String phone, String address, String accountName, String new_password){
        Statement s = null;
        String query ="UPDATE `user` set  fullName ='"+fullName+"', mail='"+ email+"',phone='"+phone+"',address = '"+address+"',username='"+accountName+"',password = '"+new_password+"' WHERE id =" +id ;
        try{
            s = ConnectionDB.connect();
            PreparedStatement ps = ConnectionDB.preparedStatementConnect(query);
//
//            ps.setString(1,fullName);
//            ps.setString(2,email);
//            ps.setString(3,phone);
//            ps.setString(4,address);
//            ps.setString(5,accountName);
//            ps.setString(6,new_password);
//            ps.setString(7,id);




        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }

}
