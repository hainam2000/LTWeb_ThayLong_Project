package database;

import model.*;
import entity.*;
import tools.MailUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) throws Exception {
        ImageEntity ie = new ImageEntity();
        CategoryEntity ce = new CategoryEntity();
        ProductEntity pe = new ProductEntity();
        UserEntity ue = new UserEntity();
        OrderEntity oe = new OrderEntity();
        Order o = new Order();

        Product product = pe.getProductWithID("1");
        Cart c = new Cart();


        String mail = "18130132@st.hcmuaf.edu.vn";
        String orderID = "16";
        String userID = "15";
        String username = "test";
        String subject = "Thanh toán thành công!";
        String productList = oe.getAllOrderDetail(orderID, userID);
        String totalPrice = "===================== \nTổng đơn hàng: " + oe.getTotalPrice(orderID, userID);
        String body = "Cảm ơn bạn đã tin tưởng dịch vụ của chúng tôi! \nDưới đây là thông tin đơn hàng " + orderID + " của bạn!\n" + productList + totalPrice;

        Mail mailsend = new Mail(mail, subject, body);

        System.out.println(body);

        //MailUtils.sendMail(mailsend);
//        mu.sendPaidMail("18130132@st.hcmuaf.edu.vn", userID, orderID);

//        oe.createOrder("2");
//        System.out.println(c.getTotalPrice());
//        c.updateProduct("1", );
//        System.out.println(c.getTotalQuantity());
//        oe.changeOrderStatus("2",c.getTotalPrice());
    }


    //Product(id, name, description, detail, price, isSale, priceSale, id_brand, storage)
    public void insertElement(String table, String values){
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            String query = "INSERT INTO " + table + " VALUES("
                    + values + ")";
            s.executeUpdate(query);
            System.out.println("all good");
        } catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }


}
