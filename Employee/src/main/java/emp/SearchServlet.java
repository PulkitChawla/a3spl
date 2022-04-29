package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			  PrintWriter out = response.getWriter();        
              String email=request.getParameter("email");            
			  Connection con=DbConn.getConn();
			  PreparedStatement ps=con.prepareStatement("select * from reg where email=?");
	          ps.setString(1,email);  
	          out.print("<body bgcolor='lightgreen' opacity=.5>");
	          out.print("<center><table width=25% border=1></center>");
              out.print("<center><h1>Result:</h1></center>");

              ResultSet rs=ps.executeQuery();                
              ResultSetMetaData rsmd=rs.getMetaData();

              while(rs.next())
              {
              out.print("<tr>");
              out.print("<td>"+rsmd.getColumnName(1)+"</td>");
              out.print("<td>"+rs.getString(1)+"</td></tr>");
              out.print("<tr><td>"+rsmd.getColumnName(2)+"</td>");
              out.print("<td>"+rs.getString(2)+"</td></tr>");
              out.print("<tr><td>"+rsmd.getColumnName(3)+"</td>");
              out.print("<td>"+rs.getString(3)+"</td></tr>");
              out.print("<tr><td>"+rsmd.getColumnName(4)+"</td>");
              out.print("<td>"+rs.getString(4)+"</td></tr>");      
              out.print("<tr><td>"+rsmd.getColumnName(5)+"</td>");
              out.print("<td>"+rs.getString(5)+"</td></tr>");      
              out.print("<tr><td>"+rsmd.getColumnName(6)+"</td>");
              out.print("<td>"+rs.getString(6)+"</td></tr>");      
              }
              out.print("</table>");
              out.print("<a href='index.jsp'>Go Back To Index</a>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		              
		doGet(request, response);
	}

}
