<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mytest.meet.MeetVo" %>
<%
	List l = (List)request.getAttribute("meetList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>姓名</th>
		<th>手机</th>
		<th>职称</th>
		<th>站点</th>
		<th>是否单间</th>
		<th>报名时间</th>
	</tr>
<%
	for(int i=0;l!=null && i<l.size();i++) {
		MeetVo vo = (MeetVo)l.get(i);
		%>
		<tr>
		<td><%=vo.getId() %></td>
		<td><%=vo.getName() %></td>
		<td><%=vo.getPhone() %></td>
		<td><%=vo.getPosition() %></td>
		<td><%=vo.getStation() %></td>
		<%
			if(vo.getOne() == 1) {
				
				%><td>是</td><%
			}
			else {
				%><td>否</td><%
			}
		%>
		<td><%=vo.getCreateTime() %></td>
		</tr>
	<% }

%>
	
</table>
</body>
</html>