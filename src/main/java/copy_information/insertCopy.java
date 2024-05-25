package copy_information;

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
import java.sql.SQLException;

@WebServlet("/InsertCopy")
public class insertCopy extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bundle_no = request.getParameter("bundle_no");
		String paper_name = request.getParameter("paper_name");
		String paper_code = request.getParameter("paper_code");
		String total_copy = request.getParameter("total_copy");
		
		
		Connection conn = null;
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");
			
			String query = "INSERT INTO copy_details VALUES(?,?,?,?)";
			PreparedStatement pds = conn.prepareStatement(query);
			
			//set the attribute values
			
			pds.setString(1,bundle_no);
			pds.setString(2,paper_name);
			pds.setString(3,paper_code);
			pds.setString(4,total_copy);
			
			
			int result = pds.executeUpdate();
			if(result > 0) {
				out.println("<h1 class = \"alert alert-primary\" role = \"alert\">Data inserted Successfully!</h1>");
			}else {
				out.println("Error of data insertion ");
			}
			
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
