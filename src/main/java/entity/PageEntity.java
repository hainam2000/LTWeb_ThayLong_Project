package entity;
import database.ConnectionDB;
import model.*;

import javax.xml.transform.Result;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class PageEntity implements Serializable {
    public int getNumberPage(int limit){

        int pages = 0;
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            ResultSet rs = s.executeQuery(  "Select count(*) from Product");
            while(rs.next()){
                int total = rs.getInt(1);
                pages = total / 20;
                if(total % 20 != 0) {
                    pages++;
                }
            }
            return pages;
        }
        catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
