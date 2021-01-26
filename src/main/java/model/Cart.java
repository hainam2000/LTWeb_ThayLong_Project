package model;

import tools.Utils;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

public class Cart implements Serializable {
    private Map<Integer, Product> productMap;
    private int shippingPrice;
    private int totalPrice;
    public Cart() {
        productMap = new HashMap<>();
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public int getTotalPrice() {
        for(Product p : productMap.values()) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }
    public void setShippingPrice(Shipping shipping) {
         this.shippingPrice = shipping.getPrice();
    }
    public int getShippingPrice() {
        return shippingPrice;
    }

    public int getTotalQuantity() {
        return  productMap.size();
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isContain(String productId) {
        if(productMap.containsKey(productId)) {
            return true;
        } else return false;
    }


    public List<Product> getProducts(){
        List<Product> productList = new LinkedList<>();
        for(Product p : productMap.values()) {
            productList.add(p);
        }
        return productList;
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
        if(productMap.containsKey(Utils.changeStringToInt(productId))) {
            System.out.println(getTotalPrice());

            productMap.get(Utils.changeStringToInt(productId)).setQuantity(Utils.changeStringToInt(quantity));
            System.out.println(productMap.get(Utils.changeStringToInt(productId)).getQuantity());

            int updatePrice = (productMap.get(Utils.changeStringToInt(productId)).getQuantity() *
                    productMap.get(Utils.changeStringToInt(productId)).getPrice());


            System.out.println(updatePrice);
            setTotalPrice(getTotalPrice() - updatePrice);

            System.out.println(getTotalPrice());
        }
    }


    public void removeProduct(String productId) {
        productMap.remove(Utils.changeStringToInt(productId));
    }


    public List<Product> getAllProduct() {
        List<Product> result = new LinkedList<>();
        for(Product p : productMap.values()) {
            result.add(p);
        }
        return result;
    }

    public static Cart getCartSession(HttpSession session) {
        return session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
    }

    public void commit(HttpSession session) {
        session.setAttribute("cart", this);
    }
}
