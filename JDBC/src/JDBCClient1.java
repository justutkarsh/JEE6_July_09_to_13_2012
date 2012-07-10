import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCClient1 {
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String connectionString = "jdbc:mysql://localhost/personsdb";
		Connection con = 
				DriverManager.getConnection(connectionString, "root", "durasoft");
		Statement stmt = con.createStatement();
		String sql = "insert into persons(first_name,last_name,age) " +
				"values('Sam','Thomas',23)";
		stmt.execute(sql);
		stmt.close();
		con.close();
		System.out.println("Success");
		
		
/*		Class cls = Class.forName("Person");
		for(int i=0;i<cls.getMethods().length;i++){
			System.out.println(cls.getMethods()[i].getName());
		}
		Person p1 = (Person)cls.newInstance();*/
	}
}
