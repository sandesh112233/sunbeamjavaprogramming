<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="clb" class = "com.sunbeam.beans.CalcBean"/>
<jsp:setProperty name = "clb" property="*"/>
<%
	clb.calcuate(); 
%>
Result:<jsp:getProperty name = "clb" property="result"/>
</body>
</html>