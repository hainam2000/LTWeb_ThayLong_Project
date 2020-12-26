package database;

import model.Product;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, details, price, isSale, priceSale, id_brand, id_category, storage)";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Statement s = ConnectionDB.connect();
        DatabaseUtils DU = new DatabaseUtils();
        String values = "'1', 'Asrock H310CM DVS LGA 1151v2'," +
                " '- Nhà sản xuất : ASROCK - Bảo hành : 36 tháng - Tình trạng: Mới 100%'," +
                "'asdasdasjdkajsldk'" +
                " '123'," +
                " '1', '32', '2', '3','124'";
        DU.insertElement(ProductTable, values);
    }

    //Product(id, name, description, detail, price, isSale, priceSale, id_brand, storage)
    public void insertElement(String table, String values){
        Statement s = null;
        try {
            s = ConnectionDB.connect();
            String query = "INSERT INTO " + table + " VALUES("
                    + values + ")";
            s.executeUpdate(query);
            System.out.println("all good");
        } catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }

}
