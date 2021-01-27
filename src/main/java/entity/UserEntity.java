package entity;

import model.Category;
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
    public List<User> getAllUser() {
        List<User> ulist = new LinkedList<>();
        Statement s = null;
        ResultSet rs = null;

        try {
            s = ConnectionDB.connect();
            rs = s.executeQuery("SELECT * from user ORDER BY id ASC ;");
            while(rs.next()){
                ulist.add(new User(
//                         public User(int id, String fullName, String email, String phone, String address, int role, String accountName, String password)
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)

                ));
            }
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return ulist;
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

    //HaiNam
    public void deleteUser(String id){
        Statement s = null;
        String query = "delete from user where id = "+id;
        try{
            s = ConnectionDB.connect();
            s.execute(query);
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    //HaiNam
    public void editUser(String id, String fullName, String email, String phone, String address, String accountName, String new_password){
        Statement s = null;
        String query ="UPDATE `user` set  fullName ='"+fullName+"', mail='"+ email+"',phone='"+phone+"',address = '"+address+"',username='"+accountName+"',password = '"+new_password+"' WHERE id ='" +id+"'" ;
        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    //HaiNam
    public int getCountId(){
        Statement s = null;
        int result ;
        String query = "SELECT count(id)  from user";
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
    //HaiNam
    public void addUser(int id, String fullName, String email, String phone, String address, String role,String accountName, String password){
        Statement s = null;
        String query = "INSERT INTO `user` value ('"+id+"','"+fullName+"','"+email+"','"+phone+"','"+address+"','"+role+"','"+accountName+"','"+password+"')" ;

        try{
            s = ConnectionDB.connect();
            s.executeUpdate(query);

        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public int getMaxId(){
        Statement s = null;
        int result ;
        String query = "SELECT  MAX(id)  from user";
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

    public String getUserMail(String userId) {
        PreparedStatement ps = null;
        String sql = "select `User`.mail from `User` WHERE `User`.id = ?";
        try{
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            } else return null;
        } catch (Exception e){
            return null;
        }
    }

    public String getUserPassword(String username, String usermail) {
        PreparedStatement ps = null;
        String sql = "SELECT `User`.`password` FROM `User` WHERE `User`.username = ? AND `User`.mail = ?";
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, username);
            ps.setString(2, usermail);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return rs.getString(1);
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }
}
