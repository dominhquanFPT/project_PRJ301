package dao;

import java.util.ArrayList;
import java.util.List;
import model.*;


public class OrderItemsDAO extends MyDAO {


    // thêm 1 orderItems vào order moi
    public void insert(int ProductID, int Quantity) {
        try {
            xSql = "INSERT INTO OrderItems (OrderID, ProductID, Quantity)\n"
                    + "SELECT MAX(id), ?, ?\n"
                    + "FROM Orders;";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, ProductID);
            ps.setInt(2, Quantity);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
