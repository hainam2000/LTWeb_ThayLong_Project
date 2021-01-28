package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int id;
    private int idProduct;
    private int idOrder;
    private int quantity;
    private int productPrice;
    private int totalPrice;
    private String productName;
    public OrderDetail() {

    }

    public OrderDetail(int id, int idProduct, int idOrder, int quantity, int productPrice, int totalPrice) {
        this.id = id;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }

    public OrderDetail(String productName, int idProduct, int idOrder, int quantity, int productPrice, int totalPrice) {
        this.productName = productName;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addOneQuantity() {
        this.quantity++;
    }
    public void removeOneQuantity(){
        this.quantity--;
    }
    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalPrice() {
        return getQuantity() * getProductPrice();
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idOrder=" + idOrder +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", totalPrice=" + totalPrice +
                ", productName=" + productName +
                '}';
    }
}
