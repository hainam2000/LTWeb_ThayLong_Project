package tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IOUtils {


    public static void saveImages(String url, String path, String folderName, String itemName){
        try(InputStream in = new URL(url).openStream()){
            Files.copy(in, Paths.get(path +"/"+ folderName + "/" + itemName));
            System.out.println("Image saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String renameFile() {

        return "";
    }

    public static void makeFolder(String name, String path){
            File theDir = new File(path  + name);
            if(!theDir.exists()){
                theDir.mkdir();
                System.out.println("Folder created");
            }
    }
}
