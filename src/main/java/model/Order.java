package model;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {
    private int id;
    private int idUser;
//    private Map<Integer, OrderDetail> orderList = new HashMap<>();
    private int totalPrice;
    private String status;

    public Order() {

    }

    public Order(int id, int idUser, int totalPrice, String status) {
        this.id = id;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

//    public double getTotalPrice() {
//        return totalPrice;
//    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addOrderDetail(OrderDetail orderDetail){

    }

//    public void addOrderDetail(OrderDetail od) {
//        if(orderList.containsKey(od.getId())) {
//            orderList.get(od.getId()).addOneQuantity();
//        } else if(!orderList.containsKey(od.getId())) {
//            orderList.put(od.getId(), od);
//        }
//    }
/*
    public void getValuesOfOrderList() {
        for(Map.Entry<Integer, OrderDetail> o : orderList.entrySet()){
            System.out.println(o.toString());
        }
    }
    public void updateQuantityOrder(String id, int quantity) {
        if(quantity < 0) {
            return;
        }
        if(orderList.containsKey(id)) orderList.get(id).setQuantity(quantity);
    }

    public void removeOrderDetail(String id) {
        orderList.remove(id);
    }

    public double getTotalPrice() {
        for(OrderDetail o : orderList.values()) {
//            totalPrice += o.getTotalPrice() * o.getQuantity();
        }
        return totalPrice;
    }
*/
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
