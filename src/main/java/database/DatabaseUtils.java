package database;

import model.Product;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseUtils {
    public static final String ProductTable = "Product(id, name, description, price, isSale, priceSale, id_brand, storage)";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Statement s = ConnectionDB.connect();
        DatabaseUtils DU = new DatabaseUtils();
        String values = "'3', 'Asrock H310CM DVS LGA 1151v2'," +
                " '- Nhà sản xuất : ASROCK - Bảo hành : 36 tháng - Tình trạng: Mới 100%'," +
                " '123'," +
                " '1', '32', '2', '124'";
        DU.insertProduct(ProductTable, values);
    }

    //Product(id, name, description, price, isSale, priceSale, id_brand, storage)
    public void insertProduct(String table, String values){
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
