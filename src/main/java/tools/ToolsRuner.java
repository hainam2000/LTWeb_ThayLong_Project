package tools;

import control.Data;
import database.DatabaseUtils;

import java.io.IOException;

public class ToolsRuner {

    public static void main(String[] args) throws IOException {
        CrawlData cd = new CrawlData();
        JSONUtils stj = new JSONUtils();
        DatabaseUtils du = new DatabaseUtils();
        int idCounter = 1;
        cd.getAllProductsOnPage("https://gearvn.com/collections/mainboard-bo-mach-chu");
        for(String str : CrawlData.itemsList){
            stj.addToProductJson(idCounter, cd.getProductName(str),
                    cd.getProductDetails(str), cd.getProductPrice(str),
                    cd.getProductPriceSale(str), 1, 123);
            idCounter++;
        }
        stj.writeJsonFile("/Users/ThienLong/Documents/empty/products.json");
        stj.readJsonFile(CrawlData.dataList, "/Users/ThienLong/Documents/empty/products.json");
        for(String value : CrawlData.dataList){
            //System.out.println(value);
            du.insertProduct("Product", value);
        }
        //System.out.println(cd.getProductPriceSale("https://gearvn.com/products/gigabyte-h470m-ds3h-rev-1-0"));
    }
}
