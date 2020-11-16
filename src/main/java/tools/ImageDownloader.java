package tools;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class ImageDownloader {
    public static void main(String[] args) throws IOException {
         //saveImage("https://product.hstatic.net/1000026716/product/h470m-ds3h-rev-1-1_f021d2e481e840e698b03196ba999c1d_large.png", "image");
    getItemImage("https://gearvn.com/products/8gb-ddr4-1x8g-2666-ram-gigabyte-memory-2666");
    }

    public static void saveImage(String url, String name) throws IOException {
        try(InputStream in = new URL(url).openStream()){
            Files.copy(in, Paths.get("/Users/ThienLong/Google Drive/Image/" + name + ".jpg"));
        }
    }
    //Get Image
    public static void getItemImage(String url) throws IOException{
        Document doc = Jsoup.connect(url).get();
        Elements imgs = doc.select("img[src$=.jpg]");
        for (Element img: imgs) {
            saveImage(img.attr("src"), getImageName(img.attr("src")));
        }
    }

    public static String getImageName(String url) throws IOException{
        String result = "";
        int count = 0;
        for(int i = 0; i < url.length(); i++){
            if(url.charAt(i) == '/'){
                count++;
                if(count == 5){
                    result = url.substring(i + 1).replace(".jpg", "");
                }
            }
        }
        return result;
    }
}
