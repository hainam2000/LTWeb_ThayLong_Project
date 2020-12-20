package model;

import java.io.Serializable;
import tools.*;
public class Product implements Serializable {
    private String id;
    private String name;
    private String type;
    private String description;
    private String imgUrl;
    private int price;
    private int salePrice;

    public Product(){

    }

    public Product(String id, String name ,String type, String description, String imgUrl, int price, int salePrice){
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.imgUrl = "http://localhost:8080/LTWeb_war_exploded/assets/images/" + type + "/" + imgUrl;
        this.price = price;
        this.salePrice = salePrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
//    private String id;
//    private String name;
//    private String detail;
//    private double price;
//    private float saleOff;
//    private double priceSale;
//    private String id_brand;
//    private int storage;
//    public Product(int id, String name, String detail, int price, float saleOff, int priceSale, int id_brand, int storage){
//        this.id = id;
//        this.name = name;
//        this.detail = detail;
//        this.price = price;
//        this.saleOff = saleOff;
//        this.priceSale = priceSale;
//        this.id_brand = id_brand;
//        this.storage = storage;
//    }
//
//
//    //Getter Setter
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getDetail() {
//        return detail;
//    }
//    public void setDetail(String detail) {
//        this.detail = detail;
//    }
//    public int getPrice() {
//        return price;
//    }
//    public void setPrice(int price) {
//        this.price = price;
//    }
//    public float getSaleOff() {
//        return saleOff;
//    }
//    public void setSaleOff(float saleOff) {
//        this.saleOff = saleOff;
//    }
//    public int getPriceSale() {
//        return priceSale;
//    }
//    public void setPriceSale(int priceSale) {
//        this.priceSale = priceSale;
//    }
//    public int getId_brand() {
//        return id_brand;
//    }
//    public void setId_brand(int id_brand) {
//        this.id_brand = id_brand;
//    }
//    public int getStorage() {
//        return storage;
//    }
//    public void setStorage(int storage) {
//        this.storage = storage;
//    }
//

}
