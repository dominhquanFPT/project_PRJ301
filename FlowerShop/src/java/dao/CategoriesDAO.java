package dao;

import java.util.*;
import model.*;


public class CategoriesDAO extends MyDAO {

    // lay ra tat ca category
    public List<Categories> getCategories() {
        List<Categories> categoriesList = new ArrayList<>();
        xSql = "SELECT * FROM Categories";
        try {
            String xName;
            int xId;
            Categories x;
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xName = rs.getString("Name");
                x = new Categories(xId, xName);
                categoriesList.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoriesList;
    }

}
