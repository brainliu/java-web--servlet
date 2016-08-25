package cn.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class index
 */
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=response.getWriter();
		String html="";
		
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		String loginname=(String)session.getAttribute("loginname");
		if (loginname==null){
			response.sendRedirect(request.getContextPath()+"/login.html");
			return;
		}
		html="<html><body>welcom back,"+loginname+",<a href='"+request.getContextPath()+"/logout'>安全退出</a></body></html>";
		writer.write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
