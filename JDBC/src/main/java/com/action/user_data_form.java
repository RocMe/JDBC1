package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user_data_form")
public class user_data_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_data_form() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        String user_name = request.getParameter("user_name");
        String new_password = request.getParameter("new_password");
        connDB cd = new connDB();
        cd.getConnection();
        String sql = "UPDATE pro_user SET user_password = '" + new_password + "' WHERE user_name = '" + user_name + "'";
        try {
            int num = cd.executeUpdate(sql);
            if(num > 0) {
                out.print("修改密码成功，请");
                out.print("<a href = 'login.jsp'>重新登录</a>");
            }
            else {
                out.print("修改密码失败，请");
                out.print("<a href = 'user_data.jsp'>重新修改</a>");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

