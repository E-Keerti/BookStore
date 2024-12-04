package aug_24;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/del")
public class DeleteBookServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String code=req.getParameter("code");
		DeleteBookDAO db=new DeleteBookDAO();
		int k=db.deleteBook(code);
		
		Cookie c[]=req.getCookies();
		if(k>0&&c!=null)
		{
			String un=c[0].getValue();
			req.setAttribute("name", un);
			
			req.setAttribute("msg","Delete BookDetails Sucesfully");
			RequestDispatcher rd = req.getRequestDispatcher("deleteBook.jsp");
			rd.forward(req, resp);
		}
		
	}

}
