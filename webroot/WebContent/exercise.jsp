<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String printMutiTable() {
			String s = "";
			for(int i=1;i<=9;i++) {
				for(int j=1;j<=i;j++) {
					s += i+"*"+j+"="+(i*j)+"   ";
				}
				s += "<br>";
			}
			return s;
		}
	%>
	<h1>九九乘法表</h1>
	<hr>
	<%=printMutiTable() %>
</body>
</html>