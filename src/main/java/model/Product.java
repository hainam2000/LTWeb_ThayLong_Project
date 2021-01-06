package model;

import java.io.Serializable;
import tools.*;
public class Product implements Serializable {
    //region Field
    private int id;
    private String name;
    private String description;
    private String details;
    private String imgUrl;
    private int price;
    private int isSale; //1 true 0 false;
    private int salePrice;
    private String brandName;
    private String categoryName;
    private int storage;
    //endregion

    //region Constructor & Getter Setter
    public Product(){

    }
    public Product(int id, String name, String description, String details, String imgUrl, int price, int isSale, int salePrice, String brandName, String categoryName, int storage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.details = details;
        this.imgUrl = "http://localhost:8080/LTWeb_war_exploded/assets/images/product/" + imgUrl + ".jpg";
        this.price = price;
        this.isSale = isSale;
        this.salePrice = salePrice;
        this.brandName = brandName;
        this.categoryName = categoryName;
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

    public String getImgUrl() { return imgUrl;}

    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

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

    public String getId_brand() {
        return brandName;
    }

    public void setId_brand(String brandName) {
        this.brandName = brandName;
    }

    public String getId_category() {
        return categoryName;
    }

    public void setId_category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price=" + price +
                ", isSale=" + isSale +
                ", salePrice=" + salePrice +
                ", id_brand=" + brandName +
                ", id_category=" + categoryName +
                ", storage=" + storage +
                '}';
    }

    //endregion

}
