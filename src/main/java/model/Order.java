package model;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private int idUser;
    private int totalPrice;
    private String status;
    private String date;

    public Order() {

    }

    public Order(int id, int idUser, int totalPrice, String status, String date) {
        this.id = id;
        this.idUser = idUser;
        this.totalPrice = totalPrice;
        this.status = status;
        this.date = date;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
