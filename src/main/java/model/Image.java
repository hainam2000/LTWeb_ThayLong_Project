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
        this.url = "http://localhost:8080/LTWeb_war_exploded/assets/images/product/" + url + ".jpg";
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
