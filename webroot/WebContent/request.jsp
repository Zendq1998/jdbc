<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request 内置对象</h1>
<%
	request.setCharacterEncoding("utf-8"); // 解决中文乱码问题，无法解决URL传递中文乱码问题。
	request.setAttribute("sex","男");
	
%>
用户名：<%=request.getParameter("username") %>
密码：<%=request.getParameter("password") %>
爱好：<%
		if(request.getParameterValues("favorite")!=null) {
			String[] favorites = request.getParameterValues("favorite");
			for(int i=0;i<favorites.length;i++) {
				out.println(favorites[i]);
			}
		}
	 %>
性别：
<%=request.getAttribute("sex") %><br>
请求体都mime类型：
<%=request.getContentType() %><br>
协议类型以及版本号：
<%=request.getProtocol() %>><br>
服务器都主机名：
<%=request.getServerName() %>
服务器端口号：
<%=request.getServerPort() %><br>
请求客户端都IP地址：
<%=request.getRemoteAddr() %><br>
请求都真实路径：
<%=request.getRealPath("request.jsp") %><br>
请求的上下文路径：
<%=request.getContextPath() %>

</body>
</html>