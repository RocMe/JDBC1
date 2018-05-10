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
import java.util.ArrayList;
import java.util.List;
import com.entity.*;

@WebServlet("/query_form")
public class query_form extends HttpServlet{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public query_form() {
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
        String str = request.getParameter("query");
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        String sql;
        String qr;
        connDB cd = new connDB();
        cd.getConnection();
        if(str.equals("项目信息")) {
            sql = "SELECT * FROM pro_info WHERE pro_id = " + id1;
            qr = "SELECT * FROM pro_manage WHERE pro_id = " + id1;
            try{
                ResultSet rs = cd.executeQuery(sql);
                ResultSet qr_rs = cd.executeQuery(qr);
                List<project> projectList = new ArrayList<project>();
                List<Integer> companyList = new ArrayList<Integer>();
                if (rs.next()) {
                    project pro = new project();
                    pro.setID(Integer.parseInt(rs.getString("pro_id")));
                    pro.setName(rs.getString("pro_name"));
                    pro.setType(rs.getString("pro_type"));
                    pro.setFare(Double.parseDouble(rs.getString("pro_fare")));
                    pro.setStatus(rs.getString("pro_status"));
                    pro.setSrartdate(rs.getString("pro_startdate"));
                    pro.setEnddate(rs.getString("pro_enddate"));
                    projectList.add(pro);
                    while(qr_rs.next()) {
                        companyList.add(Integer.parseInt(qr_rs.getString("c_id")));
                    }
                }
                request.setAttribute("projectList",projectList);
                request.setAttribute("companyList",companyList);
                request.getRequestDispatcher("query_project_result.jsp").forward(request,response);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(str.equals("公司信息")){
            sql = "SELECT * FROM company WHERE c_id = " + id1;
            qr = "SELECT * FROM pro_manage WHERE c_id = " + id1;
            try{
                ResultSet rs = cd.executeQuery(sql);
                ResultSet qr_rs = cd.executeQuery(qr);
                List<Integer> projectList = new ArrayList<Integer>();
                List<company> companyList = new ArrayList<company>();
                if (rs.next()) {
                    company com = new company();
                    com.setID(Integer.parseInt(rs.getString("c_id")));
                    com.setName(rs.getString("c_name"));
                    com.setType(rs.getString("c_type"));
                    com.setContact(rs.getString("c_contact"));
                    com.setPhone(rs.getString("c_phone"));
                    com.setEmail(rs.getString("c_email"));
                    companyList.add(com);
                    while(qr_rs.next()) {
                        projectList.add(Integer.parseInt(qr_rs.getString("pro_id")));
                    }
                }
                request.setAttribute("projectList",projectList);
                request.setAttribute("companyList",companyList);
                request.getRequestDispatcher("query_company_result.jsp").forward(request,response);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else {
            sql = "SELECT * FROM pro_manage WHERE pro_id = " + id1 + " AND c_id = " + id2;
            try{
                ResultSet rs = cd.executeQuery(sql);
                List<manage> manageList = new ArrayList<manage>();
                if (rs.next()) {
                    manage man = new manage();
                    man.setPID(Integer.parseInt(rs.getString("pro_id")));
                    man.setCID(Integer.parseInt(rs.getString("c_id")));
                    man.setContract(rs.getString("contract"));
                    man.setFare(Double.parseDouble(rs.getString("fare")));
                    manageList.add(man);
                }
                request.setAttribute("manageList",manageList);
                request.getRequestDispatcher("query_manage_result.jsp").forward(request,response);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
