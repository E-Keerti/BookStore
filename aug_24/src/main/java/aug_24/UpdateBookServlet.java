package aug_24;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
		{
		BookBean bb=new BookBean();
		bb.setBookName(req.getParameter("name"));
		bb.setBookAuthor(req.getParameter("author"));
		bb.setBookPrice(Double.parseDouble(req.getParameter("price")));
		bb.setBookQty(Long.parseLong(req.getParameter("qty")));
		bb.setBookCode(req.getParameter("code"));
		
		Cookie c[]=req.getCookies();
		UpdateDAO ud=new UpdateDAO();
		int k=ud.update(req);
		if(c!=null&&k>0)
		{
			String un=c[0].getValue();
			req.setAttribute("name",un);
			ServletContext sct=req.getServletContext();
			sct.setAttribute("bbean",bb);
			RequestDispatcher rd = req.getRequestDispatcher("updateBookDetails.jsp");
			rd.forward(req, resp);
			
		}
		else
		{
			req.setAttribute("msg","session Expired...");
			RequestDispatcher rd = req.getRequestDispatcher("msg.jsp");
			rd.forward(req, resp);
		}
	}

}
