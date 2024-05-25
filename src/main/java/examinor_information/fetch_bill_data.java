package examinor_information;

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

@WebServlet("/fetchexaminorbill")
public class fetch_bill_data extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id = req.getParameter("unique_id");  
	  resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 

        // Set up HTML table formatting for the output 
        out.println("<html><body>"); 
        out.println("<h3>Examinor Billing Details</h3>"); 
        out.println("<form style=\"border: 3px solid black; height: auto; width: auto; background-color: aqua; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\">\r\n"
        		+ "        <div class = \"container\">\r\n"
        		+ "          <label>Months and Year of Examination:</label>\r\n"
        		+ "          <input type = \"date\" name=\"timestamp\" id=\"timestamp\" required/>\r\n"
        		+ "          <br><br>\r\n"
        		+ "          <label>Name Of Claimant:</label>\r\n"
        		+ "          <input type = \"text\" name=\"fname\" id=\"fname\" required/>\r\n"
        		+ "          <br><br>\r\n"
        		+ "\r\n"
        		+ "          <label>Collage Name:</label>\r\n"
        		+ "          <input type = \"text\" name=\"cllg_name\" id=\"cllg_name\" required/>\r\n"
        		+ "          <br><br>\r\n"
        		+ "\r\n"
        		+ "          <label>Full Postal Address:</label>\r\n"
        		+ "          <input type = \"text\" name=\"address\" id=\"address\" required/>\r\n"
        		+ "          <br><br>\r\n"
        		+ "\r\n"
        		+ "          <label>Contact No:</label>\r\n"
        		+ "          <input type = \"number\" name=\"contact_no\" id=\"contact_no\"  required/>\r\n"
        		+ "          &nbsp;&nbsp;&nbsp;\r\n"
        		+ "\r\n"
        		+ "          <label>Code of Claimant:</label>\r\n"
        		+ "          <input type = \"text\" name=\"unique_id\" id=\"unique_id\" required/>\r\n"
        		+ "          <br><br>\r\n"
        		+ "        </div>\r\n"
        		+ "        <button onclick=\"fetch()\">Fetch</button>\r\n"
        		);
        out.println("<table border=2><tr>" + "<td><b>Date</b></td>" + "<td><b>Name of Class</b></td>"
                + "<td><b>Paper Code</b></td>" + "<td><b>Subject </b></td>"
                + "<td><b> Total AB Valued </b></td>" + "<td><b> Rate </b></td>" + "<td><b> Amount </b></td>" +  "<td><b> Extra No </b></td>"  +"</tr>"); 

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


    PreparedStatement ps = conn.prepareStatement("select * from examinor_information where id = ?" + id);
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      String date = rs.getString("Unique_id");
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


      out.print("<tr>" + "<td>" + date + "</td>" + "<td>" + name1 + "</td>" + "<td>" + email1 + "</td>"
                    + "<td>" + pan_no1 + "</td>" + "<td>" + aadhar_no1 + "</td>" + "<td>" + "<input type= \" text\" name = \"rate\" required>"  + "</td>" + "<td>"
          + branch + "</td>" + "<td>" + account_no1 + "</td>" + "<td>" + ifsc_code1 + "</td>" + "<td>" + 
                    qualification1 + "</td>" + "<td>" + experience1 + "</td>" + "<td>" +address + "</td>" + "<td>" + 
          mobile_no + "</td>" + "</tr>");
      
      
      
      out.println("<table border=1><tr>" + "<td><b>Date</b></td>" + "<td><b>Name of Class</b></td>"
              + "<td><b>Paper Code</b></td>" + "<td><b>Subject </b></td>"
              + "<td><b> Total AB Valued </b></td>" + "<td><b> Rate </b></td>" + "<td><b> Amount </b></td>" +  "<td><b> Extra No </b></td>"  +"</tr>");

    }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}

