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
<link rel="stylesheet" type="text/css" href="./style/common.css">
<title>Meet List</title>
</head>
<body>
<table>
	<tr>
		<th>ID</th>
		<th>姓名</th>
		<th>手机</th>
		<th>职称</th>
		<th>站点</th>
		<th>是否单间</th>
		<th>报名时间</th>
		<th>修改</th>
		<th>删除</th>
	</tr>
<%
	if(l.size() == 0) {%>
		<tr>
			<td colspan="9" class="cent">暂无信息！</td>
		</tr>
	<%} 
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
		<td>
			<button class="bt info-bg cp" onclick="updateInfo(<%=vo.getId() %>)">修改</button>
		</td>
		<td>
			<button class="bt warn-bg cp" onclick="deleteInfo(<%=vo.getId() %>)">删除</button>
		</td>
		</tr>
	<% }

%>
</table>
<div class="add-info">
	<a href="./AddInfo.html">增加信息</a>
</div>

<script type="text/javascript">
	function deleteInfo(id) {
		/* if(confirm("确定删除？")) {
			window.location.href = './DeleteInfo.html?id=' + id;
		} else {
			return 0;
		} */
		window.location.href = './DeleteInfo.html?id=' + id;
	}
	function updateInfo(id) {
		window.location.href = './UpdateInfo.html?id=' + id;
	}
</script>
</body>
<style>
.add-info {
	width: 100%;
	text-align: center;
	margin-top: 20px;
}
.add-info a {
	color: #4CAF50;
}
.add-info a:hover {
	color: #3b873f;
}
.no-bordder {
	border: none;
}
</style>
</html>