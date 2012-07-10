<html>
<body>
	<%
		if(session.getAttribute("loggedIn") != null)
			response.sendRedirect("home.jsp");
	%>
	<form action="login" method="post">
		User name <input type="text" name="username"><br/>
		Password <input type="password" name="password"><br/>
		<input type="submit" value="Login">
	</form>
	<%
		if(request.getAttribute("error") != null){
	%>
	<h1>Invalid credentials</h1>
	<%
		}
	%>
</body>
</html>