package com.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update_form")
public class update_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_form() {
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
        String str1 = request.getParameter("first");
        String str2 = request.getParameter("second");
        String str3 = request.getParameter("id");
        String str4 = request.getParameter("info");
        String table_name;
        String col_name;
        String some_col_name;
        boolean isdouble = false;
        if (str1.equals("项目信息")){
            table_name = "pro_info";
            some_col_name = "pro_id";
            if(str2.equals("0")){
                col_name = "pro_id";
            }
            else if(str2.equals("1")){
                col_name = "pro_name";
            }
            else if(str2.equals("2")){
                col_name = "pro_type";
            }
            else if(str2.equals("3")){
                col_name = "pro_fare";
                isdouble = true;
            }
            else if(str2.equals("4")){
                col_name = "pro_status";
            }
            else if(str2.equals("5")){
                col_name = "pro_startdate";
            }
            else {
                col_name = "pro_enddate";
            }
        }
        else if (str1.equals("公司信息")){
            table_name = "company";
            some_col_name = "c_id";
            if(str2.equals("0")){
                col_name = "c_id";
            }
            else if(str2.equals("1")){
                col_name = "c_name";
            }
            else if(str2.equals("2")){
                col_name = "c_type";
            }
            else if(str2.equals("3")){
                col_name = "c_contact";
            }
            else if(str2.equals("4")){
                col_name = "c_phone";
            }
            else {
                col_name = "c_email";
            }
        }
        else{
            table_name = "pro_manage";
            some_col_name = "pro_id";
            if(str2.equals("0")) {
                col_name = "contract";
            }
            else {
                col_name = "fare";
                isdouble = true;
            }
        }
        connDB cd = new connDB();
        cd.getConnection();
        String sql = "UPDATE " + table_name + " SET " + col_name + " = ";
        if(!isdouble && !col_name.equals("pro_id") && !col_name.equals("c_id")){
            sql = sql + "'";
        }
        sql = sql + str4;
        if(!isdouble && !col_name.equals("pro_id") && !col_name.equals("c_id")){
            sql = sql + "'";
        }
        sql = sql + " WHERE " + some_col_name + " = " + str3;
        try{
            int num = cd.executeUpdate(sql);
            if(num > 0){
                out.print("修改成功，请");
                out.print("<a href = 'select.jsp'>返回</a>");
            }
            else{
                out.print("修改失败，请");
                out.print("<a href = 'update.jsp'>重新修改</a>");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
