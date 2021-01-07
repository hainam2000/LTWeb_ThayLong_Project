package model;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private int idProduct;
    private String url;

    public Image(){

    }
    public Image(int id, int idProduct, String url) {
        this.id = id;
        this.idProduct = idProduct;
        this.url = url;
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

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", url='" + url + '\'' +
                '}';
    }
}
