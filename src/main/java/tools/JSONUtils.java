package tools;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class JSONUtils {

    public static JSONArray productsList = new JSONArray();
    public static JSONArray imagesList = new JSONArray();

    public void addToProductJson(int id, String name, String description, String details, int price, int priceSale, int id_brand, int id_category, int storage){
        JSONObject productDetails = new JSONObject();

        productDetails.put("id","'" + id + "'");
        productDetails.put("name","'" + name + "'");
        productDetails.put("description","'" + description + "'");
        productDetails.put("details","'" + details + "'");
        productDetails.put("price","'" + price + "'");
        productDetails.put("isSale","'" + 1 + "'");
        productDetails.put("priceSale","'" + priceSale + "'");
        productDetails.put("id_brand","'" + id_brand + "'");
        productDetails.put("id_category", "'" + id_category + "'");
        productDetails.put("storage","'" + storage + "'");

        JSONObject productObject = new JSONObject();
        productObject.put("product", productDetails);
        productsList.add(productObject);
    }
    public void addToImageJSON(int id, int idProduct, String url){
        JSONObject objectDetails = new JSONObject();
        objectDetails.put("id", "'" + id + "'");
        objectDetails.put("idProduct", "'" + idProduct + "'");
        objectDetails.put("url", "'" + url + "'");

        JSONObject imgObject = new JSONObject();
        imgObject.put("image", objectDetails);
        imagesList.add(imgObject);
    }
    public void writeJsonFile(String fileName, JSONArray writeList) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw);) {
            out.println(writeList.toJSONString());
            out.flush();
            System.out.println("Write Succeed!");
        } catch(IOException e){

        }
    }

    public List<String> readJsonFile(List<String> res, String file){
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(file)){
            Object obj = jsonParser.parse(reader);
            JSONArray list = (JSONArray) obj;
            for(Object o : list){
                res.add(parseProductObject((JSONObject) o));
                //System.out.println("||"+parseProductObject((JSONObject) o) +"||");
            }
            System.out.println("Read Succeed");
        } catch(IOException| ParseException e){
            e.printStackTrace();
        }
        return res;
    }

    public String parseProductObject(JSONObject product){
        String values = "";
        JSONObject productObject = (JSONObject) product.get("product");

        String id = (String) productObject.get("id");
        String name = (String) productObject.get("name");
        String des = (String) productObject.get("description");
        String det = (String) productObject.get("details");
        String price = (String) productObject.get("price");
        String isSale = (String) productObject.get("isSale");
        String priceSale = (String) productObject.get("priceSale");
        String id_brand = (String) productObject.get("id_brand");
        String id_category  = (String) productObject.get("id_category");
        String storage = (String) productObject.get("storage");

        values += id +", "+ name +", "+ des +", "+ det +", "+ price +", "+ isSale +", "+ priceSale +", "+ id_brand +", "+ id_category +", "+ storage;
        return values;
    }

    public String parseImageObject(JSONObject image){
        String values = "";
        JSONObject imageObject = (JSONObject) image.get("image");

        String imageID = (String) imageObject.get("id");
        String idProduct = (String) imageObject.get("idProduct");
        String url = (String) imageObject.get("url");

        values += imageID + ", " + idProduct + ", " + url;

        return values;
    }
}
