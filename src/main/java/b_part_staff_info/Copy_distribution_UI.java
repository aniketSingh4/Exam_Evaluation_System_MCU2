package b_part_staff_info;

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

@WebServlet("/b_part_copy_distribution")
public class Copy_distribution_UI extends HttpServlet{
  private static final long serialVersionUID = 2L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("bundle_no"); 
	    resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter(); 

        // Set up HTML table formatting for the output 
        out.println("<html><body><header>"); 
        out.println("<h2 class = \" text-center\" style = \"text-align:center;\">Copy Details</h3>"); 
        out.println("<table border=1 style = background-color:aqua><tr>" + 
                 "<td><b>Bundle NO</b></td>" + "<td><b>Paper Code </b></td>" + "<td><b>Paper Name </b></td>"
                + "<td><b> Total Copy </b></td>" +"</tr>"); 

    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


    PreparedStatement ps = conn.prepareStatement("SELECT Paper_Code,Paper_Name,Total_copy FROM copy_details WHERE Bundle_no = '"+id+"'");
    
  
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
      
      String paper_code = rs.getString("Paper_Code");
      String paper_name = rs.getString("Paper_Name");
      int total_copy = rs.getInt("Total_copy");
      
      out.print("<tr>" + "<td>" + id + "</td>"  +"<td>" + paper_code + "</td>"
                    + "<td>" + paper_name + "</td>" + "<td>" + total_copy + "</td>" +  "</tr></header>");
      
      out.print("<h2 style = text-align:center;>Distribute copy to examinor for B-Part Evaluation..</h2>");
      

      out.println("<html><body>");
      out.println("<div style = \"text-align:center; border:2px solid black; background-color:aqua;\">");
      out.println("<form action = \"b_part_copy_insertion\" method = \"post\" style = \"text-align:center\" >");
      out.println("<border = 2>");
  
      out.println("<br><br><label>Bundle NO:- </label>");
      out.println("<input type=\"text\" name = \"bundle_no\" id = \" bundle_no\" placeholder=\" Bundle NO\"><br><br>");
      out.println("<br><br><label>B-Part Examinor ID:- </label>");
      out.println("<input type=\"text\" name = \"unique_id\" id = \" examinor_id\" placeholder=\" Examinor ID\"><br><br>");
      out.println("<label>Date/Time:- </label>");
      out.println("<input type=\"date\" name = \"date\" id = \" date\" placeholder=\" Date \"><br><br>");
      out.println("<br><br><label>Paper Code:- </label>");
      out.println("<input type=\"text\" name = \"paper_code\" id = \" paper_code\" placeholder=\" Paper Code\"><br><br>");
      out.println("<label>Subject:- </label>");
      out.println("<input type=\"text\" name = \"subject\" id = \" subject\" placeholder=\" Subject \"><br><br>");
      out.println("<label>Total Copy:- </label>");
      out.println("<input type=\"int\" name = \"total_copy\" id = \" total_copy\" placeholder=\" Total Copy \"><br><br>");
      out.println("<input type = \"submit\" value = \"distribute\" name = \"distribute\">");
      out.println("</form");
      out.println("</div>");
      out.println("</html></body>");
      
      
    }
    }
  catch(Exception e) {
      e.printStackTrace();
    }
  }
}
  
  



