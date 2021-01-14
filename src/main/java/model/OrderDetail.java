package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int id;
    private int idProduct;
    private int quantity;
    private int productPrice;
    private double totalPrice;

    public OrderDetail() {

    }

    public OrderDetail(int id, int idProduct, int quantity, int productPrice, double totalPrice) {
        this.id = id;
        this.idProduct = idProduct;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalPrice() {
        return getQuantity() * getProductPrice();
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", quantity=" + quantity +
                ", productPrice=" + productPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
