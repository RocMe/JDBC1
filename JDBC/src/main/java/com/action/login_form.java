package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login_form")
public class login_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_form() {
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
        String name = request.getParameter("usn");
        String password = request.getParameter("pwd");
        connDB cd = new connDB();
        cd.getConnection();
        String sql = "SELECT * FROM pro_user WHERE user_name = '" + name + "' AND user_password = '" + password + "'";
        ResultSet rs = cd.executeQuery(sql);
        try{
            if(rs != null && rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("usn",name);
                request.getRequestDispatcher("user_data.jsp").forward(request,response);
            }
            else{
                out.print("登录失败，请");
                out.print("<a href = 'login.jsp'>重新登陆</a>");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}