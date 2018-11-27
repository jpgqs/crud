<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>更新员工</h3>
	<form method="post" action="update.do">
		<input type="hidden" name="id" value="${emp.id }" /> 姓名:<input
			type="text" name="name" value="${emp.name }" /> <br>薪水:<input
			type="text" name="salary" value="${emp.salary }" /><br> 年龄:<input
			type="text" name="age" value="${emp.age }" /><br> <input type="submit"
			name="更新" onclick="alert('更新成功!')" />
	</form>
</body>
</html>