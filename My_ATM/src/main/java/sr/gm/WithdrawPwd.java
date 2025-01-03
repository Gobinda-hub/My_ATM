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

@WebServlet("/withdrawPwd")
public class WithdrawPwd extends HttpServlet {
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {		
		
		String pwd = rq.getParameter("pwd");
		PrintWriter out = rp.getWriter();
		rp.setContentType("text/html");
		
		try {
			
			HttpSession session = rq.getSession();
			String em= (String) session.getAttribute("em");
			
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
				ss.setAttribute("pht", rs.getString("Photo"));
				
				RequestDispatcher rd = rq.getRequestDispatcher("/withdraw.jsp");
				rd.include(rq, rp);
			}else {
				out.print("<h3 style='color:red;margin: -32% -23% 0 15%;'>Password Didn't Match</h3>");
				RequestDispatcher rd = rq.getRequestDispatcher("/withdrawPwd.jsp");
				rd.include(rq, rp);
			}
		}catch(Exception e) {
			out.print("<h3 style='color:red'>"+ e.getMessage()+"</h3>");
			RequestDispatcher rd = rq.getRequestDispatcher("/withdrawPwd.jsp");
			rd.include(rq, rp);
		}

		
		
		
		
		
	}

}

