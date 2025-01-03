package sr.gm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/registerData")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		String nm = rq.getParameter("nm");
		String em = rq.getParameter("em");
		String pwd = rq.getParameter("pwd");
		String gnd = rq.getParameter("gnd");
		String dpo = rq.getParameter("dpo");
		
		String wth = rq.getParameter("wth");
		String avl = rq.getParameter("avl");
		
		PrintWriter out = rp.getWriter();
		rp.setContentType("text/html");
		
		
		//Image Upload
		Part file = rq.getPart("pht");
		String imgfnm = file.getSubmittedFileName();
		String uploadPath = "C:/Users/mgobi/eclipse-workspace/My_ATM/src/main/webapp/images/"+imgfnm;
		
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			
		}catch(Exception e) {
			e.getMessage();
		}
		
		
		//database connection
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase","root","Gobinda@3136"); 
			PreparedStatement ps = con.prepareStatement("insert into bank values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, nm);
			ps.setString(2, em);			
			ps.setString(3, pwd);
			ps.setString(4, gnd);
			ps.setString(5, dpo);
			ps.setString(6, wth);
			ps.setString(7, avl);
			ps.setString(8, imgfnm);			
			
			int count = ps.executeUpdate();
			
			if(count>0){
				out.print("<h3 style='color:green;margin: -32% -28% 0 12%;' >Registered Successfully</h3>");				
				RequestDispatcher rd = rq.getRequestDispatcher("/login.jsp");
				rd.include(rq, rp);
				
			}else {
				out.print("<h3 style='color:red;'>Not Registered</h3>");
				RequestDispatcher rd = rq.getRequestDispatcher("/register.jsp");
				rd.include(rq, rp);
				
			}
			
		}catch(Exception e) {
			out.print("<h3 style='color:red;'>"+e.getMessage()+"</h3>");
			RequestDispatcher rd = rq.getRequestDispatcher("/register.jsp");
			rd.include(rq, rp);
			
		}


		
		
		
	}

}

