package copyz_distribution;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class copyDistribution
 */
@WebServlet("/copyDistribution")
public class copyDistribution extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bundle_no =   request.getParameter("bundle_no");
		String examinor_id = request.getParameter("unique_id");
		String datetime =    request.getParameter("date");
		String paper_code =  request.getParameter("paper_code");
		String paper_name =  request.getParameter("subject");
		String copy =        request.getParameter("total_copy");
		
		Connection conn = null;
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");
			
			String query = "INSERT INTO copy_distribution values(?,?,?,?,?,?,?)";
			PreparedStatement pds = conn.prepareStatement(query);
			
			PreparedStatement ps = conn.prepareStatement("select * from copy_details where bundle_no ='"+bundle_no+"'");
		    ResultSet rs = ps.executeQuery();
			
			//fetch total_copy data from copy details table.
		    int number3 = 0;
		    while(rs.next()) {
			String totalcopy = rs.getString("Total_copy");
			int number1= Integer.parseInt(totalcopy);
			int number2= Integer.parseInt(copy);
			 number3 = number1 - number2;
		    }
			
			
			
			//set the attribute values
			pds.setInt(1, 0);		
			pds.setString(2,bundle_no);
			pds.setString(3,examinor_id);
			pds.setString(4,datetime);
			pds.setString(5,paper_code);
			pds.setString(6, paper_name);
			pds.setString(7, copy);
			
			
			int result = pds.executeUpdate();
			if(result > 0) {
				out.println("<h1 class = \"alert alert-primary\" role = \"alert\">Copy Distributed Successfully!</h1>");
			}else {
				out.println("Error of copy Distribution ");
			}
			
			//Write a query where we update copy count after distribute to examinor for check.
			
			
			PreparedStatement ps1 = conn.prepareStatement("UPDATE copy_details SET Total_copy = '" + number3 + "'  WHERE bundle_no = '"+bundle_no+"')");
		    
			  
		    int rs1 = ps1.executeUpdate();
			
			
		}catch(Exception e) {
			out.println("Exception : " +e.getMessage());
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	}


