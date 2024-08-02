<%@page import="models.student"%>
<%@page import="dbconnection.studentdb"%>
<%@page import="services.studentservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String pinnumber=request.getParameter("pinnumber");
studentservice service =new studentservice(studentdb.conn());
student s =service.getbystu(pinnumber);
%>
<form action="update" method="post">
<input type="text" placeholder="enter your name" name="NAME" value="<%=s.getName()%>">
<input type="email" placeholder="enter your email" name="EMAIL" value="<%=s.getEmail()%>">
<input type="text" placeholder="enter your branch" name="BRANCH" value="<%=s.getBranch()%>">
<input type="hidden" placeholder="enter your pinnumber" name="PINNUMBER" value="<%=s.getPinnumber()%>">
<button>update student</button>
</form>

</body>
</html>