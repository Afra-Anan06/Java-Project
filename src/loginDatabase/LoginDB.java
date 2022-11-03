package loginDatabase;
import java.sql.*;

public class LoginDB {
	
	public static String login(String uname,String password) throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/login";
		String un = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url,un,pass);
		Statement st = con.createStatement();
		String query = "SELECT * FROM login.login";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			if(rs.getString("username").equals(uname) && rs.getString("password").equals(password))
			{
				rs.close();
				st.close();
				con.close();
				System.out.println("Logged in");
				return uname;
			}
		}
		System.out.println("Account not found.");
		rs.close();
		st.close();
		con.close();
		return null;
	}
	
	public static void registerLogin(String uname,String pass) throws SQLException
	{
		String url ="jdbc:mysql://localhost:3306/login";
		String username = "root";
		String passsword = "root";
		Connection con = DriverManager.getConnection(url, username, passsword);
		Statement st = con.createStatement();
		String query = "INSERT INTO login.login values ('"+uname+"','"+pass+"')";
		st.executeUpdate(query);
		
		System.out.println("Login details updated");
		st.close();
		con.close();
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			LoginDB.registerLogin("Afra10", "root");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			LoginDB.login("Afra10","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
