package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewAllDAO 
{
	public BookBean bb;
	ArrayList<BookBean> al=null;
	public ArrayList<BookBean> viewAll()
	{
		try 
		{
		 Connection con=DBConnection.getConnection();
		 PreparedStatement ps = con.prepareStatement
				("SELECT * FROM BOOKDETAILS65");
		 ResultSet rs = ps.executeQuery();
		 al=new ArrayList<BookBean>();
		 while(rs.next())
		   {
			 bb=new BookBean();
			 bb.setBookCode(rs.getString(1));
			 bb.setBookName(rs.getString(2));
			 bb.setBookAuthor(rs.getString(3));
			 bb.setBookPrice(rs.getDouble(4));
			 bb.setBookQty(rs.getLong(5));
			 al.add(bb);
		   }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return al;
		
	}

}
