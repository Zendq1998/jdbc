<%@ page language="java" import="java.util.*,java.io.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=utf-8");//设置相应的mime类型
	out.println("<h1>response内置对象</h1>");
	PrintWriter outer = response.getWriter();//获得输出流对象
	out.println("大家好，我是response对象生产的输出流outer对象");
	response.sendRedirect("reg.jsp");
%>