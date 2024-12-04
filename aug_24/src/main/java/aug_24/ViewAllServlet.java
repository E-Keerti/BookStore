package aug_24;

import java.io.IOException; 
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/viewall")
public class ViewAllServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		ViewAllDAO va=new ViewAllDAO();
		ArrayList<BookBean> list =va.viewAll();
		
		Cookie c[]=req.getCookies();
		if(c==null&&list==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("msg.jsp");
		}
		else
		{
			String un=c[0].getValue();
			req.setAttribute("name",un);
			req.setAttribute("listofbooks",list);
			RequestDispatcher rd = req.getRequestDispatcher("ViewAll.jsp");
			rd.forward(req, resp);
		}
		
	}

}
