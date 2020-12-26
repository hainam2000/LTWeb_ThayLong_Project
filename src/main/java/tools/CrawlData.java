package tools;
import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import javax.print.Doc;


public class CrawlData {
    public static final String BrandName = "p > span:contains(Nhà sản xuất)";
    public static final String ProductName = "div.col-sm-6.col-xs-12.product_parameters > h1";
    public static final String ProductDescription = "div.col-sm-6.col-xs-12.product_parameters > p span";
    public static final String ProductPrice = ".product_price > del";
    public static final String ProductPriceSale = ".product_sale_price";
    public static final String ProductDetail = ".tab-pane > p";
    public static final String ProductImage = "div.container img[src~=(?i)\\.(png|jpg)]";
    public static ArrayList<String> linksList = new ArrayList<>();
    public static List<String> itemsList = new ArrayList<>();

    //region utils
    public void getAllPages(String topicUrl, int limit){
        String result = "";
        for(int i = 1; i <= limit; i++){
            result = topicUrl + i;
            linksList.add(result);
        }
    }

    public void getAllProductsOnPage( String url) throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(".product-row a[href]");
        for(Element link : links){
            String itemUrl = "https://gearvn.com" + link.attr("href");
            if(!itemsList.contains(itemUrl))
            itemsList.add(itemUrl);
        }
    }

    //endregion utils

    //region Brand
    public String getBrandName(String url) throws IOException{
        String brandName = "";
        Document doc = Jsoup.connect(url).get();
        Element e = doc.select(BrandName).get(0);
        return brandName = e.text().replace("- Nhà sản xuất : ", "");
    }
    //endregion

    //region Product
    public String getProductName(String url) throws IOException {
        String name = "";
        Document doc = Jsoup.connect(url).get();
        Element str = doc.select(ProductName).get(0);
        return name = str.text().replace("/", "");
    }
    public String getProductRename(int name){
        return "" + (name+1);
    }
    public String getProductDescription(String url) throws IOException {
        String description = "";
        Document doc = Jsoup.connect(url).get();
        Elements descriptions = doc.select(ProductDescription);
        for (Element d : descriptions) {
            description += d.text();
        }
        return description;
    }
    public int getProductPrice(String url) throws IOException{
        int price = 0;
        Document doc = Jsoup.connect(url).get();
        Elements prices = doc.select(ProductPrice);
        for (Element p : prices){
            price = Integer.parseInt(p.text().replace(",", "").replace("₫", "").replace("Liên hệ ", "10000000000"));
        }
        return price;
    }
    public int getProductPriceSale(String url) throws IOException{
        int priceSale = 0;
        Document doc = Jsoup.connect(url).get();
        Element e = doc.select(ProductPriceSale).get(0);
        priceSale = Integer.parseInt(e.text().replace("Liên hệ", "1000").replace(",", "").replace("₫", ""));
        return priceSale;
    }
    public String getProductDetail(String url) throws  IOException{
        String detail = "";
        Document doc = Jsoup.connect(url).get();
        Elements details = doc.select(ProductDetail);
        for(Element d : details){
            detail += d.text();
        }

        return detail;
    }

    //endregion
    //region Image
    public List<String> getProductImageUrls(List<String> urls,String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select(ProductImage);
        for(Element image : images){
            if(image.attr("src").contains("https:") || image.attr("src").contains("http:"))
                urls.add(image.attr("src"));
            else continue;
        }
        return urls;
    }
    public String renameProductImage(int name){
        return "" + (name+1) + ".jpg";
    }
    //endregion
    //region Backup
//    public static int counter = 0;
//    public static ArrayList<String> linksList = new ArrayList<>();
//    public static final String RAM = "https://gearvn.com/collections/ram-pc?page=";
//    public static final String MainBoard = "https://gearvn.com/collections/mainboard-bo-mach-chu?page=";
//    public static final String CPU = "https://gearvn.com/collections/cpu-bo-vi-xu-ly?page=";
//    public static final String VGA = "https://gearvn.com/collections/vga-card-man-hinh?page=";
//    public static final String SSD = "https://gearvn.com/collections/ssd-o-cung-the-ran?page=";
//    public static final String HDD = "https://gearvn.com/collections/hdd-o-cung-pc?page=";
//
//    public static void main(String[] args) throws IOException {
//        double startTime = System.nanoTime();
//        System.out.println("Start");
//        getAllPages(RAM, 3);
//        getAllPages(MainBoard, 7); //limit = 10
//        getAllPages(CPU, 5);//limit = 5
//        getAllPages(VGA, 4);//limit = 9
//        getAllPages(SSD, 4);//limit = 5
//        getAllPages(HDD, 2);//limit = 2
//        for(int i = 0; i < linksList.size(); i++){
//            System.out.println("******************" + linksList.get(i) + "******************");
//            getAllItems(linksList.get(i));
//        }
//        System.out.println("================================******************************************====================================");
//        double endTime   = System.nanoTime();
//        double totalTime = ((endTime - startTime)/1000000000)/60;
//        System.out.println("END");
//        System.out.println("total products: " + counter);
//        System.out.println("total runtime: " + totalTime);
//    }
//
//    public static void getAllPages(String topic, int limit){
//        String result = "";
//        for(int i = 1; i <= limit; i++){
//            result = topic + i;
//            linksList.add(result);
//        }
//    }
//
//
//    //lay link tung san pham va crawl du lieu
//    public static void getAllItems(String url) throws IOException{
//        Document doc = Jsoup.connect(url).get();
//        Elements links = doc.select(".product-row a[href]");
//        System.out.println("========================================================================");
//        for(Element link : links){
//            counter++;
//            String itemUrl = "https://gearvn.com" + link.attr("href");
//            System.out.println("item link : " + itemUrl);
//            getItemName(itemUrl);
//            getItemImage(itemUrl);
//            getItemPrice(itemUrl);
//            getItemInform(itemUrl);
//            System.out.println("========================================================================");
//        }
//    }
//    //Get Name
//    public static void getItemName(String url) throws  IOException{
//        Document doc = Jsoup.connect(url).get();
//        Elements names = doc.select("div.col-sm-6.col-xs-12.product_parameters > h1");
//        for (Element name: names) {
//            System.out.println("\nname : " + name.text());
//        }
//    }
//    //Get Image
//    public static void getItemImage(String url) throws IOException{
//        Document doc = Jsoup.connect(url).get();
//        Elements imgs = doc.select("img[src$=.jpg]");
//        for (Element img: imgs) {
//            System.out.println("\nimage : " + img.attr("src"));
//        }
//    }
//    //Get Price
//    public static void getItemPrice(String url) throws IOException{
//        Document doc = Jsoup.connect(url).get();
//        Elements prices = doc.select(".product_price > del");
//        for(Element price : prices){
//            System.out.println("\nprice : " + price.text());
//        }
//    }
//    //Get Information
//    public static void getItemInform(String url) throws IOException{
//        Document doc = Jsoup.connect(url).get();
//        Elements informTopic = doc.select(".specTopic");
//        Elements informDetails = doc.select(".specDetail");
//        int length = informTopic.size();
//        System.out.println("inform: ");
//        for(int i = 1; i < length; i++){
//            System.out.println(informTopic.get(i).text() + " - " + informDetails.get(i).text());
//        }
//    }
    //endregion
}