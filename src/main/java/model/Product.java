package model;

import java.io.Serializable;
import tools.*;
public class Product implements Serializable {
    //region Field
    private int id;
    private String name;
    private String description;
    private String details;
    private int price;
    private int isSale; //1 true 0 false;
    private int salePrice;
    private int id_brand, id_category;
    private int storage;
    //endregion

    //region Constructor & Getter Setter
    public Product(){

    }
    public Product(int id, String name, String description, String details, int price, int isSale, int salePrice, int id_brand, int id_category, int storage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.details = details;
        this.price = price;
        this.isSale = isSale;
        this.salePrice = salePrice;
        this.id_brand = id_brand;
        this.id_category = id_category;
        this.storage = storage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }


    //endregion

}
