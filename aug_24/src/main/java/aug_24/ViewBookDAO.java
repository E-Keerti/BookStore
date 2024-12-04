package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBookDAO 
{
	public BookBean viewBook(String code)
	{
		BookBean bb = null;
		try
		{
		  Connection con=DBConnection.getConnection();
	    	PreparedStatement ps = con.prepareStatement
	    			("select * from  bookdetails65 where code=?");
	    	ps.setString(1,code);
	    	 ResultSet rs = ps.executeQuery();
	    	 {
	    		 if(rs.next())
	    		 {
	    			 bb=new BookBean();
	    			 bb.setBookCode(code);
	    			 bb.setBookName(rs.getString(2));
	    			 bb.setBookAuthor(rs.getString(3));
	    			 bb.setBookPrice(rs.getDouble(4));
	    			 bb.setBookQty(rs.getLong(5));
	    		 }
	    	 }
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAO"+bb);
		return bb;
		
	}

}
