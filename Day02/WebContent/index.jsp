<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<%
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("USA");
		countries.add("UK");
		session.setAttribute("countries",countries);
	%>
<body>
	
	<c:choose>
		<c:when test="${countries.size() > 3}">
			<h4>Hugely populated</h4>
		</c:when>
		<c:otherwise>
			<h4>Less than or equal to 3 countries</h4>
		</c:otherwise>
	</c:choose>
	<c:forEach items="${countries}" var="country">
		<h2>${country}</h2>
	</c:forEach>

	<c:if test="${loggedIn}">
		<c:redirect url="home.jsp"></c:redirect>
	</c:if>
	
	<form action="login" method="post">
		User name <input type="text" name="username"><br/>
		Password <input type="password" name="password"><br/>
		<input type="submit" value="Login">
	</form>
	<h1>${error}</h1>
</body>
</html>