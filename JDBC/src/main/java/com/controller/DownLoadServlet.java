package com.controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //得到要下载的文件名
        OutputStream out = response.getOutputStream();



        String filename = request.getParameter("filename");

// 文本从Brower传递是被编码为IOS-8859-1，需要转换成utf-8

        String filename_utf = new String(filename.getBytes("ISO-8859-1"),"utf-8");



        if (filename_utf == null || filename_utf.equals(""))

        {

            out.write("请输入文件名！".getBytes("utf-8"));

            response.setContentType("text/html;charset=utf-8");

            out.close();

            return;

        }

// 获得服务器中文件的真实存储路径

        String filePath = this.getServletContext().getRealPath("/WEB-INF/upload/" + filename_utf);



        int indexIndector = filename_utf.indexOf(".");

// 获得提取文件的文件后缀，包括.号

        String indector  = filename_utf.substring(indexIndector, filename_utf.length());

// 由文件的全路径获得要下载文件的InputStream

        InputStream is = new FileInputStream(new File(filePath));



        Date date = new Date();

        long time = date.getTime();

// 设置响应头的MIME类型

        response.setContentType("application/force-download");

        response.setHeader("Content-Length",String.valueOf(is.available()));

        response.setHeader("Content-Disposition", "attachment;filename=" + time + indector);



        int i = 0;

        byte[] b = new byte[1024];

        while ((i = is.read(b)) != -1)

        {

            out.write(b, 0, i);

        }

        is.close();

        out.close();
    }


    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}