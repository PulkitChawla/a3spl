package emp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class RegServlet
 */
//@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Connection con=DbConn.getConn();
			boolean register=true;
			
//			
			String email=request.getParameter("email");
			
			 Statement st=con.createStatement();
			 ResultSet rs=st.executeQuery("select * from reg");
			 while(rs.next()){				 
			 	if(rs.getString(2).equals(email)){
			 		RequestDispatcher rd=request.getRequestDispatcher("reg.html");
				 	out.print("<font color ='red'>User Already Exists.");
				 	rd.include(request,response);
				 	register = false;
			 	  }
			 }
			 	if(register) {
			  		String name=request.getParameter("name");
			 		String pwd=request.getParameter("pwd");
					String cpwd=request.getParameter("cpwd");
					String city=request.getParameter("city");
					String state=request.getParameter("state");
					String gender=request.getParameter("gender");
					String nation=request.getParameter("coun");
					String mob=request.getParameter("mob");
					PreparedStatement ps=con.prepareStatement("insert into reg values(?,?,?,?,?,?,?,?,?)");
					ps.setString(1,name);
					ps.setString(2,email);
					ps.setString(3,pwd);
					ps.setString(4,cpwd);
					ps.setString(5,city);
					ps.setString(6,state);
					ps.setString(7,gender);
					ps.setString(8,nation);
					ps.setString(9, mob);
					HttpSession session=request.getSession();
					session.setAttribute("currentUser",name);
					int i = ps.executeUpdate();
					out.println(i);
					out.println("updated");
					if(i>0) {
						out.print("Successfully Registered");
						RequestDispatcher rd=request.getRequestDispatcher("wel.jsp");
						rd.forward(request, response);
					} else {
						out.print("Not Registered");
						RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);						
					}
			 	
//			 
			 
//			String username="";
//			if(email.equals(username)) {
//				check=false;
//				out.print("UserName already exists");
//			}
//			if(pwd!=null && cpwd!=null) {
//				if(pwd.equals(cpwd)) {
//					
//					int i=ps.executeUpdate();
//					if(i>0) {
//						out.print("Successfully Registered");
//						RequestDispatcher rd=request.getRequestDispatcher("wel.jsp");
//						rd.forward(request, response);
//					}
				//}
//				else {
//					out.print("Password doesnt match");
//				}
			}	 
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
