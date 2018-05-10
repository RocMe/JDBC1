package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.entity.user;
import com.dao.userDAO;

@WebServlet("/register_form")
public class register_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_form() {
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
        user new_user = new user();
        new_user.setName(name);
        new_user.setPassword(password);
        userDAO ud = new userDAO();
        ud.getConnection();
        if(ud.addUser(new_user)){
            out.print("注册成功，请");
            out.print("<a href = 'login.jsp'>登陆</a>");
        }
        else{
            out.print("注册失败，请");
            out.print("<a href = 'register.jsp'>重新注册</a>");
        }
    }
}
