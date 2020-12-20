package tools;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class JSONUtils {

    public static void main(String[] args) throws IOException, ParseException {
        CrawlData cd = new CrawlData();
        JSONUtils stj = new JSONUtils();

        String path = "/Users/ThienLong/Documents/empty/products.json";
//        String url1 = "https://gearvn.com/products/asrock-h310cm-dvs-lga-1151v2";
//        String url = "https://gearvn.com/products/msi-gtx-1650-ventus-xs-4gb-gddr6";
//        //stj.createJsonFile(path);
//
//
//        stj.addToProductJson(1, cd.getProductName(url),
//                cd.getProductDetails(url), cd.getProductPrice(url),
//                cd.getProductPriceSale(url), 1,123);
//        stj.addToProductJson(1, cd.getProductName(url1),
//                cd.getProductDetails(url1), cd.getProductPrice(url1),
//                cd.getProductPriceSale(url1), 1,123);
//        stj.writeJsonFile(path);

        //stj.parseProductObject(path);
        //stj.readJsonFile(path);
    }

    public static JSONArray productsList = new JSONArray();
    public void addToProductJson(int id, String name, String description, int price, int priceSale, int id_brand, int storage){
        JSONObject productDetails = new JSONObject();

        productDetails.put("id","'" + id + "'");
        productDetails.put("name","'" + name + "'");
        productDetails.put("description","'" + description + "'");
        productDetails.put("price","'" + price + "'");
        productDetails.put("isSale","'" + 1 + "'");
        productDetails.put("priceSale","'" + priceSale + "'");
        productDetails.put("id_brand","'" + id_brand + "'");
        productDetails.put("storage","'" + storage + "'");

        JSONObject productObject = new JSONObject();
        productObject.put("product", productDetails);
        productsList.add(productObject);
    }

    public void writeJsonFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw);) {
            out.println(productsList.toJSONString());
            out.flush();
        } catch(IOException e){

        }
    }

    public List<String> readJsonFile(List<String> res, String file){
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(file)){
            Object obj = jsonParser.parse(reader);
            JSONArray productList = (JSONArray) obj;
            for(Object o : productList){
                res.add(parseProductObject((JSONObject) o));
                //System.out.println("||"+parseProductObject((JSONObject) o) +"||");
            }
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
        String price = (String) productObject.get("price");
        String isSale = (String) productObject.get("isSale");
        String priceSale = (String) productObject.get("priceSale");
        String id_brand = (String) productObject.get("id_brand");
        String storage = (String) productObject.get("storage");

        values += id +", "+ name +", "+ des +", "+ price +", "+ isSale +", "+ priceSale +", "+ id_brand +", "+ storage;
        return values;
    }
}
