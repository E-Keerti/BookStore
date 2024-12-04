package aug_24;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		AdminBean ab=new AdminBean();
		ab.setAdminName(req.getParameter("name"));
		ab.setAdminPass(req.getParameter("pass"));
		ab.setAdminFName(req.getParameter("fname"));
		ab.setAdminLName(req.getParameter("lname"));
		ab.setAdminMailId(req.getParameter("mailid"));
		ab.setAdminPhNo(Long.parseLong(req.getParameter("phno")));
		
		RegisterDAO rdao=new RegisterDAO();
		int k=rdao.reg(ab);
		if(k>0)
		{
			req.setAttribute("msg","User registered Sucessfully....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("RegisterSucess.jsp");
			rd.forward(req, resp);
		}
	}

}
