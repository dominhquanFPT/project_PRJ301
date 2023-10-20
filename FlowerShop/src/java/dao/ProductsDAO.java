package dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.Products;

public class ProductsDAO extends MyDAO {
    
    //lay ra danh sách tat ca san pham
    public List<Products> getAllProducts() {
        List<Products> productList = new ArrayList<>();
        xSql = "SELECT * FROM Products";
        try {
            int id, price, categoryID;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                categoryID = rs.getInt("CategoryID");
                Products p = new Products(id, name, description, price, image, categoryID);
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    // lay ra san pham theo category
    public List<Products> getProductsByCategoryID(int categoryID) {
        List<Products> productList = new ArrayList<>();
        xSql = "SELECT * FROM Products WHERE CategoryID = ?";
        try {
            int id, price;
            String name, description, image;
            Products product;
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryID);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                product = new Products(id, name, description, price, image, categoryID);
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

   
    

}
