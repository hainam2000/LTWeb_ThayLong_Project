package entity;

import database.ConnectionDB;
import model.OrderDetail;
import model.Product;
import model.Order;
import tools.Utils;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public String getAllOrderDetail(String orderID, String userID) {
        String result = "";
        String sql = "select Product.`name`, OrderDetail.quantity, OrderDetail.price, OrderDetail.total_price, `Order`.create_day FROM OrderDetail JOIN Product ON OrderDetail.id_product = Product.id JOIN `Order` ON OrderDetail.id_order = `Order`.id WHERE `Order`.id_user = ? AND `Order`.id = ? AND `Order`.`status` LIKE 'da thanh toan'";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, userID);
            ps.setString(2, orderID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result += rs.getString(1) + "\t\t\t\t\t\t" + rs.getString(2) + "\t" +rs.getString(3) + "\t" +rs.getString(4) + "\t" +rs.getString(5) + "\n";
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public String getUnpaidOrder(String userID) {
        String sql = "select `Order`.id FROM `Order` WHERE `Order`.id_user = ? AND `Order`.`status` LIKE 'da thanh toan'";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String getTotalPrice(String orderID) {
        String sql = "select `Order`.total_price FROM `Order` WHERE `Order`.id = ?";
        PreparedStatement ps = null;
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, orderID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            } else return null;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Order> getAllOrder() {
        List<Order> olist = new LinkedList<>();
        PreparedStatement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM `order` ORDER BY id_user asc,id asc;";
        try {
            s = ConnectionDB.preparedStatementConnect(sql);
            rs = s.executeQuery();

            while(rs.next()){
                olist.add(new Order(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
            return  olist;
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getAllOrderByUserID(String userID) {
        List<Order> orderList = new LinkedList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from `Order`WHERE `Order`.id_user = ?;";
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                orderList.add( new Order(
                    rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getString(5))
                );
            }
            return orderList;
            } catch (Exception e) {
            return null;
        }

    }


    public List<OrderDetail> getAllOrderDetailsByOrderID(String orderID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select Product.`name`, OrderDetail.id_product, OrderDetail.id_order, OrderDetail.quantity, OrderDetail.price, OrderDetail.total_price FROM OrderDetail JOIN `Order` On `Order`.id = OrderDetail.id_order JOIN Product ON OrderDetail.id_product = Product.id WHERE `Order`.id = ?";
        List<OrderDetail> orderDetails = new LinkedList<>();
        try {
            ps = ConnectionDB.preparedStatementConnect(sql);
            ps.setString(1, orderID);
            rs = ps.executeQuery();
            while(rs.next()) {
                orderDetails.add(new OrderDetail(
                        rs.getString(1),
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
}
