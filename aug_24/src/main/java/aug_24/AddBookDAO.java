package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookDAO
{
	public int k=0;
	public int addBook(BookBean bb)
	{
		try
		{
		   Connection con=DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into bookdetails65 values(?,?,?,?,?)");
			ps.setString(1,bb.getBookCode());
			ps.setString(2,bb.getBookName());
			ps.setString(3,bb.getBookAuthor());
			ps.setDouble(4,bb.getBookPrice());
			ps.setLong(5,bb.getBookQty());
			k = ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return k;
		
	}
	
}
