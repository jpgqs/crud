<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored ="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

</style>
<title>listEmp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" >
 
</head>
<body>
	<table class="table table-hover table table-bordered">
	<caption class="text-center " >员工信息</caption>
	<tr>
		<td>编号</td>
		<td>姓名</td>
		<td>薪水</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>	
	<c:forEach items="${requestScope.listEmp }" var="emp">
	<tr>
			<td>${emp.id }</td>
			<td>${emp.name }</td>
			<td>${emp.salary }</td>
			<td>${emp.age }</td>
			<td><a href="delete.do?id=${emp.id }" onclick="return confirm('是否确认删除${emp.name }信息?')">删除</a> <a href="load.do?id=${emp.id }">更新</a></td>
		</tr>
		</c:forEach>
	</table>
	<a style="display: block; text-align: center; font-size:20px " href="addEmp.jsp">添加员工</a>
</body>
</html>