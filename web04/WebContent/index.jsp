<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello, my first JSP!大家好</h1>
	<%!
		String s = "张三";
		int add(int x,int y) {
			return x+y;
		}
	%>
	<%
		out.println("欢迎大家学习javaee开发");
	%>
	你好，<%=s %><br>
	x+y=<%=add(2,3) %>
</body>
</html>
