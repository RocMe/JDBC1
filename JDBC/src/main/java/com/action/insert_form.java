package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.entity.*;
import com.dao.*;

@WebServlet("/insert_form")
public class insert_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_form() {
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
        String str = request.getParameter("insert");
        if(str.equals("项目信息")) {
            int pro_id = Integer.parseInt(request.getParameter("pid"));
            String pro_name = request.getParameter("pn");
            String pro_type = request.getParameter("pt");
            double pro_fare = Double.parseDouble(request.getParameter("pf"));
            String pro_status = request.getParameter("ps");
            String start_date = request.getParameter("std");
            String end_date = request.getParameter("end");
            project pro = new project();
            pro.setID(pro_id);
            pro.setName(pro_name);
            pro.setType(pro_type);
            pro.setFare(pro_fare);
            pro.setStatus(pro_status);
            pro.setSrartdate(start_date);
            pro.setEnddate(end_date);
            projectDAO pd = new projectDAO();
            pd.getConnection();
            connDB cd = new connDB();
            cd.getConnection();
            String sql = "SELECT * FROM pro_info WHERE pro_id = " + pro_id;
            ResultSet rs = cd.executeQuery(sql);
            try{
                if(rs != null && rs.next()){
                    out.println("该项目已存在！");
                }
                else{
                    if(pd.addProject(pro)){
                        out.print("添加成功，请");
                        out.print("<a href = 'select.jsp'>返回</a>");
                    }
                    else{
                        out.print("添加失败，请");
                        out.print("<a href = 'insert.jsp'>重新添加</a>");
                    }
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(str.equals("公司信息")) {
            int c_id = Integer.parseInt(request.getParameter("cid"));
            String c_name = request.getParameter("cn");
            String c_type = request.getParameter("ct");
            String c_contact = request.getParameter("cc");
            String c_phone = request.getParameter("cp");
            String c_email = request.getParameter("ce");
            company com = new company();
            com.setID(c_id);
            com.setName(c_name);
            com.setType(c_type);
            com.setContact(c_contact);
            com.setPhone(c_phone);
            com.setEmail(c_email);
            companyDAO cod = new companyDAO();
            cod.getConnection();
            connDB cd = new connDB();
            cd.getConnection();
            String sql = "SELECT * FROM company WHERE pro_id = " + c_id;
            ResultSet rs = cd.executeQuery(sql);
            try{
                if(rs != null && rs.next()){
                    out.println("该公司已存在！");
                }
                else{
                    if(cod.addCompany(com)){
                        out.print("添加成功，请");
                        out.print("<a href = 'select.jsp'>返回</a>");
                    }
                    else{
                        out.print("添加失败，请");
                        out.print("<a href = 'insert.jsp'>重新添加</a>");
                    }
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else {
            int pro_id = Integer.parseInt(request.getParameter("pid"));
            int c_id = Integer.parseInt(request.getParameter("cid"));
            String contract = request.getParameter("contract");
            double fare = Double.parseDouble(request.getParameter("fare"));
            manage man = new manage();
            man.setPID(pro_id);
            man.setCID(c_id);
            man.setContract(contract);
            man.setFare(fare);
            manageDAO md = new manageDAO();
            md.getConnection();
            connDB cd = new connDB();
            cd.getConnection();
            String sql = "SELECT * FROM pro_info WHERE pro_id = " + pro_id + " AND c_id = " + c_id;
            ResultSet rs = cd.executeQuery(sql);
            try{
                if(rs != null && rs.next()){
                    out.println("该关系已存在！");
                }
                else{
                    if(md.addManage(man)){
                        out.print("添加成功，请");
                        out.print("<a href = 'select.jsp'>返回</a>");
                    }
                    else{
                        out.print("添加失败，请");
                        out.print("<a href = 'insert.jsp'>重新添加</a>");
                    }
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
