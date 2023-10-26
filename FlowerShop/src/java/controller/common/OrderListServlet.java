package controller.common;

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "OrderListServlet", urlPatterns = {"/orderlist"})
public class OrderListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //gọi ra dữ liệu của phiên người dùng hiện tại
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");

        OrdersDAO od = new OrdersDAO();
        List<Orders> listO;
        if (u.getRole() == 1 || u.getRole() == 2) { // neu la admin, lay ra danh sach tat ca order
            listO = od.getAllOrders();
        } else { // neu la customer, lay ra nhung don hang cua chinh minh
            listO = od.getMyOrders(u.getID());
        }

        request.setAttribute("listO", listO);
        request.getRequestDispatcher("orderList.jsp").forward(request, response);

    }

}
