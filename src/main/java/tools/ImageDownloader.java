package tools;

import org.apache.jasper.tagplugins.jstl.core.Url;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.*;

public class ImageDownloader {
    public static void main(String[] args) throws IOException {
        ImageDownloadTools("https://product.hstatic.net/1000026716/product/h470m-ds3h-rev-1-1_f021d2e481e840e698b03196ba999c1d_large.png");
    }
    public static void ImageDownloadTools(String path) throws IOException {
        URL url = new URL(path);
        BufferedImage img = ImageIO.read(url);
        File file = new File("/Users/ThienLong/Google Drive/resources/");
        ImageIO.write(img, "jpg", file);
    }
}
