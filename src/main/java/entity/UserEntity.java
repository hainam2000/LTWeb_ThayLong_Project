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
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }
}
