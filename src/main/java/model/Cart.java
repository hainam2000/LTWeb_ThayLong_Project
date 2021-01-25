package model;

import tools.Utils;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    private Map<Integer, Product> productMap;
    private double totalPrice;
    public Cart() {
        productMap = new HashMap<>();
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public List<Product> getProducts(){
        List<Product> productList = new LinkedList<>();
        for(Product p : productMap.values()) {
            productList.add(p);
        }
        return productList;
    }
    public double getTotalPrice() {
        for(Product p : productMap.values()) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }
    public double getShippingPrice() {
        return 12000;
    }
    public int getTotalQuantity() {
        return  productMap.size();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public boolean isContain(Product product) {
        if(productMap.containsKey(product.getId())) {
            return true;
        } else return false;
    }
    public void addProduct(Product product) {
        if(productMap.containsKey(product.getId())) {
            productMap.get(product.getId()).addOneQuantity();
            productMap.get(product.getId()).take();
        } else {
            productMap.put(product.getId(), product);
            productMap.get(product.getId()).addOneQuantity();
            productMap.get(product.getId()).take();
        }
    }


    public void updateProduct(String productId, String quantity) {
        if(Utils.changeStringToInt(quantity) <= 0) return;
        else if(productMap.containsKey(Utils.changeStringToInt(productId))) {
            productMap.get(Utils.changeStringToInt(productId)).setQuantity(Utils.changeStringToInt(quantity));
            productMap.get(Utils.changeStringToInt(productId)).updateStorage(Utils.changeStringToInt(quantity));
        }
    }
    public void removeProduct(String productId) {
        productMap.remove(Utils.changeStringToInt(productId));
    }
    public double setTotalPrice() {
        for(Product p : productMap.values()) {
            this.totalPrice += p.getPrice() * p.getQuantity();
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
