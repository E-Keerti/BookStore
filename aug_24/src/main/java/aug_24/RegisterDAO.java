package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO 
{
	public int k=0;
	public int reg(AdminBean ab)
	{
		try {
        Connection con=null;
		con=DBConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement
					("insert into adminreg65 values(?,?,?,?,?,?)");

		ps.setString(1,ab.getAdminName());
		ps.setString(2,ab.getAdminPass());
		ps.setString(3,ab.getAdminFName());
		ps.setString(4,ab.getAdminLName());
		ps.setString(5,ab.getAdminMailId());
		ps.setLong(6,ab.getAdminPhNo());
		k = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return k;
	}
	
}
