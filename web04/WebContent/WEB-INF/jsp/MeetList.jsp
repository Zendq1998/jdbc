<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mytest.meet.MeetVo" %>
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
	<c:forEach items="${meetMap.data}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.phone}</td>
			<td>${vo.position}</td>
			<td>${vo.station}</td>
			<c:if test="${vo.one==1}">
				<td>是</td>
			</c:if>
			<c:if test="${vo.one==0}">
				<td>否</td>
			</c:if>
			<td>${vo.getCreateTime()}</td>
			<td>
			<button class="bt info-bg cp" onclick="updateInfo(${vo.id})">修改</button>
		</td>
		<td>
			<button class="bt warn-bg cp" onclick="deleteInfo(${vo.id})">删除</button>
		</td>
		</tr>
	</c:forEach>
	<c:if test="${meetList.size() == 0}">
		<tr>
			<td colspan="9" class="cent">暂无信息！</td>
		</tr>
	</c:if>
</table>

<div class="add-info">
	<a href="./AddInfo.html">增加信息</a>
</div>

<c:if test="${meetMap.sp != null}">
<tr>
	<td colspan="6">
		<span>共${meetMap.sp.count}条记录</span>
		<span>共${meetMap.sp.totalpage}页</span>
		<span>第${meetMap.sp.page}页</span>
		<span><a href="./MeetList.html?page=${meetMap.sp.firstPage}">首页</a></span>
		<span><a href="./MeetList.html?page=${meetMap.sp.prePage}">上一页</a></span>
		<span><a href="./MeetList.html?page=${meetMap.sp.nextPage}">下一页</a></span>
		<span><a href="./MeetList.html?page=${meetMap.sp.lastPage}">尾页</a></span>
	</td>
</tr>
</c:if>

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