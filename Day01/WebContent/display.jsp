<%@page import="com.durasoft.domain.Person"%>
<%@page import="java.util.ArrayList"%>
<html>
<body>
	<%
		ArrayList<Person> persons = (ArrayList<Person>)request.getAttribute("persons");
		if(persons.size() > 0){
	%>

	<table border="1">
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
		</thead>
		<tbody>
			<%
				for(Person person : persons){
			%>	
			<tr>
				<td><%=person.getFirstName() %></td>
				<td><%=person.getLastName() %></td>
				<td><%=person.getAge() %></td>
			</tr>	
			<%
				}
			%>
		</tbody>
	</table>
	<%
		}
	%>
</body>
</html>