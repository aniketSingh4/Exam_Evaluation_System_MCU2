package copy_information;

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

@WebServlet("/fetchCopy")
public class fetch_copy extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 

        // Set up HTML table formatting for the output 
        out.println("<html><body>"); 
        out.println("<h3>Examinor Information Details</h3>"); 
        out.println("<table border=1 style = background-color:aqua><tr>" + "<td><b>Bundle_NO</b></td>"
                + "<td><b>Paper Code</b></td>" + "<td><b>Paper Name </b></td>"
                + "<td><b> Total Copy </b></td>" +"</tr>"); 

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


    PreparedStatement ps = conn.prepareStatement("SELECT * FROM copy_details");
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      String bundle_no = rs.getString("bundle_no");
      String paper_code = rs.getString("paper_code");
      String paper_name = rs.getString("paper_name");
      String total_copy = rs.getString("total_copy");
      
      out.print("<tr>" +  "<td>" + bundle_no + "</td>" + "<td>" + paper_code + "</td>"
                    + "<td>" + paper_name + "</td>" + "<td>" + total_copy + "</td>" +  "</tr>");

    }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}

