package model;

import javax.servlet.http.HttpSession;
import java.util.*;

public class Cart extends HashMap {
    private Map<Integer, OrderDetail> orderDetailList = new HashMap<>();
    private double totalPrice;
    public Cart() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addOrderDetail(OrderDetail od) {
        if(orderDetailList.containsKey(od.getId())) {
            orderDetailList.get(od.getId()).addOneQuantity();
        } else {
            orderDetailList.put(od.getId(), od);
        }
    }

    public void updateOrderDetail(int orderDetailId, int quantity) {
        if(quantity <= 0) return;
        else if(orderDetailList.containsKey(orderDetailId)) {
            orderDetailList.get(orderDetailId).setQuantity(quantity);
        }
    }
    public void removeOrderDetail(int orderDetailId) {
        orderDetailList.remove(orderDetailId);
    }

    public double setTotalPrice() {
        for(OrderDetail od : orderDetailList.values()) {
            this.totalPrice += od.getProductPrice() * od.getQuantity();
        }
        return totalPrice;
    }

    public static Cart getCartSession(HttpSession session) {
        return session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
    }

    public void commit(HttpSession session) {
        session.setAttribute("cart", this);
    }
}
