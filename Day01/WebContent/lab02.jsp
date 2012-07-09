<%@page import="java.util.Date"%>
<html>
	<body>
		<h3>
			Current time <%= new Date() %>
		</h3>
		<h3>
			You have visited <%= request.getRequestURL().toString() %>
		</h3>
		<h3>
			Web server host name <%=request.getServerName() %>
		</h3>
		<h4>
			Web server info:<%=request.getServletContext().getServerInfo() %>,
			Port: <%=request.getServerPort() %>
		</h4>
		<h3>
			Client <%=request.getRemoteHost() %>, <%=request.getRemoteAddr() %>
		</h3>
	</body>
</html>