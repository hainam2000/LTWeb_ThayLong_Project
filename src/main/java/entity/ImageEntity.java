package entity;

import database.ConnectionDB;
import model.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ImageEntity {
    public List<Image> getAllImageWithProductID(String productID){
        List<Image> result = new LinkedList<>();
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT Image.idImage, Image.idProduct, Image.url from Image INNER JOIN Product ON Image.idProduct = Product.id WHERE Product.id = '" + productID + "' GROUP BY Image.idImage ");
            while(rs.next()) {
                result.add(new Image(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
            return result;
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return result;
        }
    }
    public Image getOneImageWithProductID(String productID){
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery("SELECT Image.idImage, Image.idProduct, Image.url from Image INNER JOIN Product ON Image.idProduct = " + productID + " WHERE Product.id = 1 AND Image.url LIKE '%/1.jpg'");

            return new Image(
                    rs.getInt(1), rs.getInt(2), rs.getString(3)
            );
        }
        catch(ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void deleteImageWithIdAndPid(String id,String pid){
        Statement s = null;
        String query = "delete from image where idImage = '"+id+"' AND idProduct='"+pid+"'";
        try{
            s = ConnectionDB.connect();
            s.execute(query);
        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
    public int getCountIdOfSingleProduct(String pid){
        Statement s = null;
        int result ;
        String query = "SELECT idProduct,COUNT(idImage) count from image ";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query +" WHERE idProduct ='"+pid+"' GROUP BY  idProduct");

            if(rs.next()){
                return result = rs.getInt(2);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getMaxIdOfSingleProduct(String pid){   //use to get the biggest id of the product you need
        Statement s = null;
        int result ;
        String query = "SELECT idProduct,MAX(idImage) count from image ";
        ResultSet rs;
        try{
            s = ConnectionDB.connect();
            rs = s.executeQuery(query +" WHERE idProduct ='"+pid+"' GROUP BY  idProduct");

            if(rs.next()){
                return result = rs.getInt(2);
            }


        }
        catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
