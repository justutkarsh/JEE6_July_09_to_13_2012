<html>
	<body>
		<%!
			public void doSomething(){}
			private static int numberOfServlets;
		
		%>
		<h2>
			<%= "INTUIT(This is an expression)" %>
		</h2>
		<h1>
			<%
				//scriptlet
				//gets inserted inside the doGet/doPost method of the
				//generated servlet
				//out,request,response,session
				int hellooooooo = 99999;
				out.println("hello");
				
			%>
			This is Lunch.jsp
		</h1>
	</body>
</html>