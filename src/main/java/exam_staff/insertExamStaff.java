package exam_staff;

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

@WebServlet("/InsertExamStaff")
public class insertExamStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String unique_id = request.getParameter("unique_id");
		String name = request.getParameter("fname");
		String email = request.getParameter("email");
		String pan_no = request.getParameter("pan_no");
		String aadhar_no = request.getParameter("aadhar_no");
		String bank_name = request.getParameter("bank_name");
		String branch = request.getParameter("branch");
		String account_no = request.getParameter("account_no");
		String ifsc_code = request.getParameter("ifsc_code");
		String qualification = request.getParameter("qualification");
		String experience = request.getParameter("experience");
		String address = request.getParameter("address");
		String mobile_no = request.getParameter("mobile_no");
		
		Connection conn = null;
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");
			
			String query = "INSERT INTO exam_staff_info VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pds = conn.prepareStatement(query);
			
			//set the attribute values
			pds.setString(1,unique_id);
			pds.setString(2,name);
			pds.setString(3,email);
			pds.setString(4,pan_no);
			pds.setString(5,aadhar_no);
			pds.setString(6,bank_name);
			pds.setString(7,branch);
			pds.setString(8,account_no);
			pds.setString(9,ifsc_code);
			pds.setString(10,qualification);
			pds.setString(11,experience);
			pds.setString(12,address);
			pds.setString(13,mobile_no);
			
			int result = pds.executeUpdate();
			if(result > 0) {
				out.println("data inserted successfully");
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
