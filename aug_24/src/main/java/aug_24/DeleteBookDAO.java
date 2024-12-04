package aug_24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBookDAO 
{
	public int k=0;
   public int deleteBook(String code) 
   {
	   try
	   {
	   Connection con=DBConnection.getConnection();
	   PreparedStatement ps = con.prepareStatement
			   ("delete from bookdetails65 where code=?");
	   ps.setString(1, code);
	   k = ps.executeUpdate();
	   } 
	   catch (SQLException e) 
	   {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	return k;
    
   }
   
}
