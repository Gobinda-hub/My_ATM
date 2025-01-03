package sr.gm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginData")
public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp)throws ServletException, IOException{
		String em = rq.getParameter("em");
		String pwd = rq.getParameter("pwd");
		PrintWriter out = rp.getWriter();
		rp.setContentType("text/html");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","Gobinda@3136");
			PreparedStatement ps = con.prepareStatement("select*from bank where Email = ? and Password = ?");
			ps.setString(1, em);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				HttpSession ss = rq.getSession();
				ss.setAttribute("nm", rs.getString("Name"));
				ss.setAttribute("em", rs.getString("Email"));
				ss.setAttribute("dpo", rs.getString("Deposit"));
				ss.setAttribute("gnd", rs.getString("Gender"));
				ss.setAttribute("pht", rs.getString("Photo"));
				
				RequestDispatcher rd = rq.getRequestDispatcher("/profile.jsp");
				rd.include(rq, rp);
			}else {
				out.print("<h3 style='color:red;margin: -32% -25% 0 15%;'>Invalid Details</h3>");
				RequestDispatcher rd = rq.getRequestDispatcher("/login.jsp");
				rd.include(rq, rp);
			}
		}catch(Exception e) {
			out.print("<h3 style='color:red'>"+ e.getMessage()+"</h3>");
			RequestDispatcher rd = rq.getRequestDispatcher("/login.jsp");
			rd.include(rq, rp);
		}
		
	}
	
}


