<html>
<body>
	<%
		if(session.getAttribute("loggedIn") != null){
	%>
	<jsp:forward page="home.jsp"></jsp:forward>
	
	<% } %>
	<form action="login" method="post">
		User name <input type="text" name="username"><br/>
		Password <input type="password" name="password"><br/>
		<input type="submit" value="Login">
	</form>
	<h1>${error}</h1>
</body>
</html>