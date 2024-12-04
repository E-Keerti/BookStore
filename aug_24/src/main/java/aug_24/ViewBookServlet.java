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
@WebServlet("/view")
public class ViewBookServlet extends HttpServlet
{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException
		{
			String code=req.getParameter("code");
			
			ViewBookDAO vb=new ViewBookDAO();
		    BookBean bb = vb.viewBook(code);
		    
		   System.out.println("Servlet"+bb);
		    Cookie c[]=req.getCookies();
		    
		    
		    if(bb!=null&&c!=null)
		    {
		    	String un=c[0].getValue();
		    	req.setAttribute("name",un);
		    	
		    	ServletContext sct=req.getServletContext();
		    	sct.setAttribute("bbean",bb);
				RequestDispatcher rd = req.getRequestDispatcher("viewProfile.jsp");
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
