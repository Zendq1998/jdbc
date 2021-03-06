<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./style/common.css">
<link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">添加信息</h1>
	<form action="PostInfo.html" method="post" class="add-form">
		<table>
			<tr>
				<td>id：</td>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>职称：</td>
				<td>
					<input type="text" name="position">
				</td>
			</tr>
			<tr>
				<td>手机：</td>
				<td>
					<input type="text" name="phone">
				</td>
			</tr>
			<tr>
				<td>到达站点</td>
				<td>
					<label class="cp">
						武汉站
						<input type="radio" name="station" value="武汉站">
					</label>
					<label class="cp">
						汉口站
						<input type="radio" name="station" value="汉口站">
					</label>
					<label class="cp">
						武昌站
						<input type="radio" name="station" value="武昌站">
					</label>
					<label class="cp">
						天河机场
						<input type="radio" name="station" value="天河机场">
					</label>
				</td>
			</tr>
			<tr>
				<td>到站日</td>
				<td><input type="text" id="datepicker" size="30" name="createTime"></td>
			</tr>
			<tr>
				<td>是否单住</td>
				<td>
					<label class="cp">
						是
						<input type="radio" name="one" value=1>
					</label>
					<label class="cp">
						否
						<input type="radio" name="one" value=0>
					</label>
				</td>
			</tr>
		</table>
		<div  class="cp" style="margin:0 auto;width:100px">
			<input type="submit" value="提交/添加">
		</div>
	</form>
</body>
<script type="text/javascript">
$(function() {
    $( "#datepicker" ).datepicker();
    $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
  });
</script>
</html>

<style>
.add-form {
	width: 50%;
	margin: 0 auto;
}
</style>