package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contact_us_form")
public class contact_us_form extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact_us_form() {
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String advice = request.getParameter("advice");
        connDB cd = new connDB();
        cd.getConnection();
        String sql = "INSERT INTO advice VALUES('" + name + "','" + email + "','" + advice + "')";
        try{
            int num = cd.executeUpdate(sql);
            if(num > 0) {
                out.print("提交成功，请");
                out.print("<a href = 'contact_us.jsp'>返回</a>");
            }
            else{
                out.print("提交失败，请");
                out.print("<a href = 'contact_us.jsp'>重新提交</a>");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
