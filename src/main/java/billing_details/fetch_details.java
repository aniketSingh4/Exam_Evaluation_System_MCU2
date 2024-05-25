package billing_details;

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

@WebServlet("/fetchBillData")
public class fetch_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("unique_id");
		resp.setContentType("text/html"); 
        PrintWriter out = resp.getWriter();
        
     // Set up HTML table formatting for the output
        out.println("<html><body>");
    	out.println("<h1 style=\"text-align:center;\">Examinor Billing Details </h1>");
        out.println("<form border=1 style = \"background-color:aqua; border:2px solid black; text-align:center; width:350px; height:190px; margin:10px; padding:10px;\">");
        out.println("<div> <label>Unique ID:</label><input type=\"text\" name = \"unique_id\" id = \"unique_id\" value = \"unique_id\"></div></br>");
        out.println("<div> <label>Name of Examinor:</label><input type=\"text\" name = \"fname\" id = \"fname\" value = \"name1\"></div></br>");
        out.println("<div> <label>Address:</label><input type=\"text\" name = \"address\" id = \"address\" value = \"address\"></div></br>");
        out.println("<div> <label>Contact No:</label><input type=\"text\" name = \"contact_no\" id = \"contact_no\" value = \"contact_no\"></div></br>");
        out.println("<div> <label>Email No:</label><input type=\"text\" name = \"email\" id = \"email\" value = \"email\"></div>");
        out.println("</form>");
        
            out.println("<h3>Examinor Information Details</h3>"); 
            out.println("<table border=1 style = background-color:aqua><tr>" + "<td><b>Bundle_NO</b></td>" + "<td><b>Date</b></td>"
            + "<td><b>Paper Code</b></td>" + "<td><b>Subject </b></td>"
            + "<td><b> Total Valued </b></td>" + "<td><b> Rate </b></td>" + "<td><b> Extra </b></td>" +  "<td><b> Amount($) </b></td>" +"</tr>"); 
        
		
     
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_valuation_system","root","Aniket123@");


            PreparedStatement ps = conn.prepareStatement("select * from examinor_information where id = '"+id+"'");
            ResultSet rs = ps.executeQuery();
            
            PreparedStatement cd = conn.prepareStatement("select Bundle_no,DateTime,Paper_code,Paper_name,Total_copy from copy_distribution where Unique_id = '"+id+"'");
            ResultSet dc = cd.executeQuery();
            
            
        
            while(dc.next()) {
            	String bundle_no = rs.getString("Bundle_no");
            	String datetime = rs.getString("DateTime");
            	String paper_code = rs.getString("Paper_code");
            	String paper_name = rs.getString("Paper_name");
            	String total_copy = rs.getString("Total_copy");
            	
            	
            	 out.print("<tr>" + "<td>" + bundle_no + "</td>" + "<td>" + datetime + "</td>" + "<td>" + paper_code + "</td>"
                         + "<td>" + paper_name + "</td>" + "<td>" + total_copy + "</td>" + "<td>" + "</tr>");
            }
                
          
            
    
          }
         catch(Exception e) {
           e.printStackTrace();
           }
          }
         }
