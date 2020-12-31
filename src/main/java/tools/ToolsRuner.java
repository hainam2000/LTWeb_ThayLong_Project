package tools;

import database.DatabaseUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class ToolsRuner {

    public static void main(String[] args) throws IOException, InterruptedException {
        Random r = new Random();
        CrawlData cd = new CrawlData();
        JSONUtils stj = new JSONUtils();
        IOUtils ioUtils = new IOUtils();
        List<String> dataList = new ArrayList<>();
        List<String> imgList = new ArrayList<>();
        DatabaseUtils du = new DatabaseUtils();



        String jsonFile = "/Users/ThienLong/Documents/empty/HDDImages.json";
        String itemUrls = "https://gearvn.com/products/asus-prime-h310m-cs-r2-0-lga1151v2";
        String pageUrl = "https://gearvn.com/collections/mainboard-bo-mach-chu";
        String path = "/Users/ThienLong/Documents/empty/";
        String categoryUrl = "https://gearvn.com/collections/hdd-o-cung-pc?page=";

        boolean isMake = false;
        int counter = 0;
        int productID = 549;
/*
        cd.getAllPages(categoryUrl,9);
        for (String link: CrawlData.linksList) {
            cd.getAllProductsOnPage(link);
            Thread.sleep(2000);
        }
        for(String url : CrawlData.itemsList){
            int imageID = 1;
            String folderName = productID + "";//cd.getProductRename(CrawlData.itemsList.indexOf(url));
            ioUtils.makeFolder(folderName,path);
            cd.getProductImageUrls(imgList, url);
                for (String imgUrl: imgList) {
                    IOUtils.saveImages(imgUrl,path,folderName,cd.renameProductImage(imgList.indexOf(imgUrl)));
                    stj.addToImageJSON(imageID,productID,productID + "/" + imageID);
                    imageID++;
                    Thread.sleep(2000);
                }
            imgList.clear();
            productID++;
            Thread.sleep(2000);
        }
        stj.writeJsonFile(path + "HDDImages.json", JSONUtils.imagesList);
*/
        stj.readImageJsonFile(dataList, jsonFile);
        for (String value : dataList ) {
            du.insertElement("Image", value);
            counter++;
        }
        System.out.println("Total values: " + counter);
        /*
        int idCounter = 1;
        int itemCounter = 0;
        String url = "https://gearvn.com/collections/hdd-o-cung-pc?page=";


        cd.getAllPages(url,9);
        for (String link: CrawlData.linksList) {
            cd.getAllProductsOnPage(link);
            Thread.sleep(2000);
        }
        //cd.getAllProductsOnPage();

        for(String str : CrawlData.itemsList){
            stj.addToProductJson(idCounter, cd.getProductName(str),
                    cd.getProductDescription(str),cd.getProductDetail(str), cd.getProductPrice(str),
                    cd.getProductPriceSale(str), 1, 5,r.nextInt(100));
            idCounter++;
            itemCounter++;
            //Thread.sleep(2000);
        }
        System.out.println("item: " + itemCounter);

        stj.writeJsonFile("/Users/ThienLong/Documents/empty/products.json");

        stj.readJsonFile(dataList, "/Users/ThienLong/Documents/empty/products.json");
        for(String value : dataList){
            //System.out.println(value);
            du.insertProduct("Product", value);
        }


        //System.out.println(cd.getProductPriceSale("https://gearvn.com/products/gigabyte-h470m-ds3h-rev-1-0"));
         */
    }
}
