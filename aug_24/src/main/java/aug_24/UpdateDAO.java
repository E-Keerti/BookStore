package aug_24;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public class UpdateDAO 
{
	public int k=0;
	public int update(HttpServletRequest req)
	{
		try 
		{
		Connection con=DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement
		("update bookdetails65 set name=?,author=?,price=?,qty=? where code=?");
		
		ps.setString(1,req.getParameter("name"));
		ps.setString(2,req.getParameter("author"));
		ps.setString(3,req.getParameter("price"));
		ps.setString(4,req.getParameter("qty"));
		ps.setString(5,req.getParameter("code"));
	
	    k = ps.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
		
	}

}
