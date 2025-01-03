package sr.gm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {		
		
		String amt = rq.getParameter("amt");
		PrintWriter out = rp.getWriter();
		rp.setContentType("text/html");
		
	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","Gobinda@3136"); 
			PreparedStatement ps = con.prepareStatement("update bank set Deposit=Deposit-? ");
			
			ps.setString(1, amt);			
			
			int count = ps.executeUpdate();
			
			if(count>0){
				out.print("<h3 style='color:green;margin: -32% -26% 0 12%;' >Withdraw Successfully</h3>");				
				RequestDispatcher rd = rq.getRequestDispatcher("/profile.jsp");
				rd.include(rq, rp);
				
			}else {
				out.print("<h3 style='color:red; margin: -32% -23% 0 15%;'>Error Occur</h3>");
				RequestDispatcher rd = rq.getRequestDispatcher("/withdraw.jsp");
				rd.include(rq, rp);
				
			}
			
		}catch(Exception e) {
			out.print("<h3 style='color:red;margin: -32% -23% 0 15%;'>Not Deposited</h3>");
			RequestDispatcher rd = rq.getRequestDispatcher("/withdraw.jsp");
			rd.include(rq, rp);
			
		}


		
		
		
		
		
	}

}

