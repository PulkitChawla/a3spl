package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogServlet
 */
//@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			Connection con=DbConn.getConn();
			String email=request.getParameter("email");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			PreparedStatement ps=con.prepareStatement("select * from reg where email=? and pwd=?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				HttpSession session=request.getSession();
				request.setAttribute("currentUser",name);
				out.println("Login Successfull ");
				RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd1=request.getRequestDispatcher("log.jsp");
				out.print("<font color ='red'>Invalid Login Credentials");
				rd1.forward(request, response);
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
