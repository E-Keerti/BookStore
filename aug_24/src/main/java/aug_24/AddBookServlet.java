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
@WebServlet("/add")
public class AddBookServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		BookBean bb=new BookBean();
				
		bb.setBookCode(req.getParameter("code"));
		bb.setBookName(req.getParameter("name"));
		bb.setBookAuthor(req.getParameter("author"));
		bb.setBookPrice(Double.parseDouble(req.getParameter("price")));
		bb.setBookQty(Long.parseLong(req.getParameter("qty")));
		
		AddBookDAO ab=new AddBookDAO();
		int k = ab.addBook(bb);
		
		
		Cookie c[]=req.getCookies();
		if(c!=null && k>0)
		{
			String un=c[0].getValue();
			req.setAttribute("name",un);
			req.setAttribute("msg","BookDetails Added");
			RequestDispatcher rd = req.getRequestDispatcher("addBook.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("msg","session expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("msg.jsp");
			rd.forward(req, resp);
		}
		
	}

}
