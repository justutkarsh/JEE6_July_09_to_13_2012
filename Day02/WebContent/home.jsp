<html>
<body>
	<%
		if(session.getAttribute("loggedIn") == null)
			response.sendRedirect("index.jsp");
	%>
	<h1>Welcome admin</h1>
	
	<br/>
	<br/>
	<a href="logout">Logout</a>
</body>
</html>