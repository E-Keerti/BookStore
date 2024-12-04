package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
	public AdminBean ab;
	public AdminBean login(String uN,String pW)
	{
		try
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement
			("select * from adminreg65 where aname=? and apass=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ab=new AdminBean();
				ab.setAdminName(rs.getString(1));
				ab.setAdminPass(rs.getString(2));
				ab.setAdminFName(rs.getString(3));
				ab.setAdminLName(rs.getString(4));
				ab.setAdminMailId(rs.getString(5));
				ab.setAdminPhNo(rs.getLong(6));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		return ab;
		
	}

}
