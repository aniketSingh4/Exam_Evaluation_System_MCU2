package exam_staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fetchExamStaff")
public class fetchExamStaff extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 

        // Set up HTML table formatting for the output 
        out.println("<html><body>"); 
        out.println("<h3>Examinor Information Details</h3>"); 
        out.println("<table border=1 style = background-color:aqua><tr>" + "<td><b>Unique_ID</b></td>" + "<td><b>Name</b></td>"
                + "<td><b>Email</b></td>" + "<td><b>Pan_no </b></td>"
                + "<td><b> Aadhar_no </b></td>" + "<td><b> Bank Name</b></td>" + "<td><b> Branch </b></td>" +  "<td><b> Account No </b></td>"  + "<td><b> IFSC Code </b></td>" +
                "<td><b> Qualification </b></td>" +  "<td><b> Experience </b></td>" +  "<td><b> Address </b></td>" +  "<td><b> Mobile No </b></td>" +"</tr>"); 

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


    PreparedStatement ps = conn.prepareStatement("select * from exam_staff_info");
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      String unique_id1 = rs.getString("Unique_id");
      String name1 = rs.getString("Name");
      String email1 = rs.getString("Email");
      String pan_no1 = rs.getString("Pan_no");
      String aadhar_no1 = rs.getString("Aadhar_no");
      String bank_name1 = rs.getString("Bank_name");
      String branch = rs.getString("Branch");
      String account_no1 = rs.getString("Account_no");
      String ifsc_code1 = rs.getString("IFSC_Code");
      String qualification1 = rs.getString("Qualification");
      String experience1 = rs.getString("Experience");
      String address = rs.getString("Address");
      String mobile_no = rs.getString("Mobile_no");


      out.print("<tr>" + "<td>" + unique_id1 + "</td>" + "<td>" + name1 + "</td>" + "<td>" + email1 + "</td>"
                    + "<td>" + pan_no1 + "</td>" + "<td>" + aadhar_no1 + "</td>" + "<td>" + bank_name1  + "</td>" + "<td>"
          + branch + "</td>" + "<td>" + account_no1 + "</td>" + "<td>" + ifsc_code1 + "</td>" + "<td>" + 
                    qualification1 + "</td>" + "<td>" + experience1 + "</td>" + "<td>" +address + "</td>" + "<td>" + 
          mobile_no + "</td>" + "</tr>");

    }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}

