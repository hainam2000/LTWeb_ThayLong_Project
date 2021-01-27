package entity;

import database.ConnectionDB;
import model.Cart;
import model.Order;
import model.OrderDetail;
import model.Product;
import tools.Utils;

import javax.swing.*;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OrderEntity implements Serializable {
    public static void createOrder(String userID) {
        String query = "INSERT INTO `Order`(`Order`.id_user, `Order`.`status`, `Order`.total_price, `Order`.create_day) VALUES (?,'chua thanh toan', 0, CURRENT_DATE)";
        PreparedStatement s = null;
        try {
            s = ConnectionDB.preparedStatementConnect(query);
            s.setString(1, userID);
            s.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newOrderDetail(String productID) {
        String sql = "insert into OrderDetail(id_product, price, quantity, total_price) SELECT Product.id, Product.price, 1, Product.price * 1 FROM Product where Product.id = ?";
        PreparedStatement ps = null;
        try{
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, productID);
            ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExistBlankOrder(String userID) {
        String sql = "select * from `Order` WHERE `Order`.id_user = ? AND `Order`.`status` = 'chua thanh toan'";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public OrderDetail getOrderDetailByPID(String productID) {
        String sql = "select * from OrderDetail where OrderDetail.id_product = ?";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            newOrderDetail(productID);
            ps.setString(1, productID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new OrderDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<OrderDetail> getAllOrderDetailByOrderID(String orderId) {
        String sql = "select OrderDetail.id, OrderDetail.id_product, OrderDetail.id_order, OrderDetail.quantity, OrderDetail.price, OrderDetail.total_price FROM OrderDetail JOIN `Order` On `Order`.id = OrderDetail.id_order WHERE `Order`.id = ?";
        PreparedStatement ps = null;
        List<OrderDetail> orderDetails = new LinkedList<>();
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1,orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                orderDetails.add(new OrderDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return orderDetails;
        } catch (Exception e) {
            return null;
        }
    }

    public Order getOrder(String userID) {
        String sql = " select `Order`.id, `Order`.id_user, `Order`.`status`, `Order`.total_price FROM `Order` JOIN `User` ON `User`.id = `Order`.id_user WHERE `User`.id = ? AND `Order`.`status` = 'chua thanh toan'";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Order(rs.getInt(1),
                rs.getInt(2),
                rs.getInt(4),
                rs.getString(3));
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void addProductToOrderDetails(List<Product> productList, String userID) {
        String sql = "insert into OrderDetail(OrderDetail.id_product, OrderDetail.id_order, OrderDetail.price, OrderDetail.quantity, OrderDetail.total_price) SELECT Product.id, `Order`.id, Product.price," +
                " ?" +
                ", ? * Product.price " +
                "from Product JOIN `Order` JOIN `User` ON `Order`.id_user = `User`.id WHERE Product.id = ? " +
                "AND `Order`.`status`='chua thanh toan' AND `User`.id = ?;";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            for (Product p : productList) {
                ps.setInt(1, p.getQuantity());
                ps.setInt(2, p.getQuantity());
                ps.setInt(3, p.getId());
                ps.setInt(4, Utils.changeStringToInt(userID));
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeOrderStatus(String userID, int totalPrice) {
        String sql = "update `Order` SET `Order`.`status` = 'da thanh toan', `Order`.total_price = ?, `Order`.create_day = CURRENT_DATE WHERE `Order`.id_user = ? AND `Order`.`status` = 'chua thanh toan'";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setInt(1, totalPrice);
            ps.setString(2, userID);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addCartToOrder(String userID) {


//                bat userID vo button,
//                vong lap cart, cho vao orderDetail va order
//                order co userID = userID
//                bat dang nhap
    }
}
