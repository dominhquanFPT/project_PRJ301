package dao;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class UsersDAO extends MyDAO {

    // hàm dang nhâp
    public Users Login(String email, String pass) {
        xSql = "select * from Users where email = ? and password = ?";
        String xName, xPass, xEmail;
        int xId, xRole;
        Users x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("ID");
                xName = rs.getString("Name");
                xEmail = rs.getString("email");
                xPass = rs.getString("password");
                xRole = rs.getInt("role");

                x = new Users(xId, xName, xEmail, xPass, xRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

}
