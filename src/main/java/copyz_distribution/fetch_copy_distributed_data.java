package copyz_distribution;

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

@WebServlet("/fetchCopyDistributedData")
public class fetch_copy_distributed_data extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 

        // Set up HTML table formatting for the output 
        out.println("<html><body>"); 
        out.println("<h3>Examinor Information Details</h3>"); 
        out.println("<table border=1 style = background-color:#417761><tr>" + "<td><b>SNo</b></td>" + "<td><b>Bundle No</b></td>"
                + "<td><b>Unique ID</b></td>" + "<td><b>DateTime </b></td>"
                + "<td><b> Paper Code </b></td>" + "<td><b> Paper Name</b></td>" + "<td><b> Total Copy </b></td>"  +"</tr>"); 

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


    PreparedStatement ps = conn.prepareStatement("select * from copy_distribution");
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      String SNo = rs.getString("SNO");
      String unique_id1 = rs.getString("Unique_id");
      String bundle_no = rs.getString("Bundle_no");
      String dateTime = rs.getString("DateTime");
      String paper_code = rs.getString("Paper_code");
      String paper_name = rs.getString("Paper_name");
      String total_copy = rs.getString("Total_copy");
      


      out.print("<tr>" + "<td>" + SNo + "</td>" + "<td>" + bundle_no + "</td>" + "<td>" + unique_id1 + "</td>"
                    + "<td>" + dateTime + "</td>" + "<td>" + paper_code + "</td>" + "<td>" + paper_name  + "</td>" + "<td>"
          + total_copy + "</td>" + "</tr>");

    }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}

