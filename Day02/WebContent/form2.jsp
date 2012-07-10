<h1>
	<jsp:include page="date.jsp"></jsp:include>
</h1>

<jsp:useBean id="person1" scope="session" class="com.durasoft.Person">
</jsp:useBean>

<h2>
	<jsp:getProperty property="firstName" name="person1"/>
</h2>

<h2>
	<jsp:getProperty property="age" name="person1"/>
</h2>

<%-- <h1>${person1.firstName.toUpperCase()}</h1>
<h1>${person1.age}</h1> --%>