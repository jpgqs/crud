<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addEmp</title>
</head>
<body>
	<h3>增加员工</h3>
	<form method="post" action="add.do">
	姓名:<input type="text" name="name"/><br>
	薪水:<input type="text" name="salary"/><br>
	年龄:<input type="text" name="age"/><br>
	<input type="submit" name="add"  value="增加" onclick="alert('添加成功')"/>
	</form>
</body>
</html>