<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.twd.jwt_auth.util.Jwtutil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String token =(String) session.getAttribute("token");
		/* out.println("Token on Dashboard: "+token); */
		String username = null;
		if(token!=null){
			username  = Jwtutil.validateToken(token);
		}
		if (username == null){
	        response.sendRedirect("login.jsp");
	        return;
		}
	%>
	<h3>
		Welcome
		<%=username%>
	</h3>
</body>
</html>