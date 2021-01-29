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
        int tempPrice = 0;
        for(Product p : productMap.values()) {
            tempPrice += p.getPrice() * p.getQuantity();
        }
        return tempPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalPrice() {
        for(Product p : productMap.values()) {
            this.totalPrice += p.getPrice() * p.getQuantity();
        }
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


    public List<Product> getProducts(){
        List<Product> productList = new LinkedList<>();
        for(Product p : productMap.values()) {
            productList.add(p);
        }
        return productList;
    }

    public void addProduct(Product product) {
        if(productMap.containsKey(product.getId())) {
            productMap.get(product.getId()).setQuantity(productMap.get(product.getId()).getQuantity() + 1);
            productMap.get(product.getId()).take();
        } else {
            productMap.put(product.getId(), product);productMap.get(product.getId()).setQuantity(productMap.get(product.getId()).getQuantity() + 1);
            productMap.get(product.getId()).take();
        }
    }

    public void updateProduct(String productId, String quantity) {
        if(Utils.changeStringToInt(quantity) <= 0) return;
        if(productMap.containsKey(Utils.changeStringToInt(productId))) {
            productMap.get(Utils.changeStringToInt(productId)).setQuantity(Utils.changeStringToInt(quantity));
            productMap.get(Utils.changeStringToInt(productId)).updateStorage(Utils.changeStringToInt(quantity));
        }
    }

    public void removeOneQuantityProduct(String productId) {
        if(productMap.containsKey(Utils.changeStringToInt(productId))) {
            if(productMap.get(Utils.changeStringToInt(productId)).getQuantity() > 1) {
                productMap.get(Utils.changeStringToInt(productId)).setQuantity(productMap.get(Utils.changeStringToInt(productId)).getQuantity() - 1);
                productMap.get(Utils.changeStringToInt(productId)).updateStorage(productMap.get(Utils.changeStringToInt(productId)).getStorage() + 1);
            } else if(productMap.get(Utils.changeStringToInt(productId)).getQuantity() == 1) {
                removeProduct(productId);
            }
        }
    }

    public void removeProduct(String productId) {
        productMap.remove(Utils.changeStringToInt(productId));
        productMap.get(Utils.changeStringToInt(productId)).updateStorage(productMap.get(-Utils.changeStringToInt(productId)).getQuantity());
    }

    public void removeAll() {
        productMap.clear();
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
    public static void quit(HttpSession session) {
        session.removeAttribute("cart");
    }
}
