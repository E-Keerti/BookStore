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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		String aName=req.getParameter("name");
		String pW=req.getParameter("pass");
		
		LoginDAO ld=new LoginDAO();
		AdminBean ab=ld.login(aName, pW);
		
		if(ab==null)
		{
			req.setAttribute("msg","Invalid UserId...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("msg.jsp");
			rd.forward(req, resp);
		}
		else
		{
			ServletContext sct=req.getServletContext();
			sct.setAttribute("abean", ab);
			
			Cookie ck=new Cookie("name",ab.getAdminName());
			resp.addCookie(ck);
			
			req.setAttribute("msg","Login Sucessfull");
			RequestDispatcher rd=req.getRequestDispatcher("LoginSucess.jsp");
			rd.forward(req, resp);
		}
		
	}

}
