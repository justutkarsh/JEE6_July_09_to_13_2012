<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%
	Context context = new InitialContext();
	DataSource ds = (DataSource)context.lookup("java:/PersonsDB");
	Connection con =  ds.getConnection();
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from persons");
	while(rs.next()){
		out.println(rs.getString("first_name") + ", " + rs.getString("last_name"));
	}
	rs.close();
	con.close();
%>