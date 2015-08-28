

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bullhorn;
import model.BullhornProfile;
import customTools.DBUtil;

/**
 * Servlet implementation class Profiles
 */
@WebServlet("/Profiles")
public class Profiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// res.setContentType("text/html");        

		String oneProfile = req.getParameter("use");
		if (oneProfile != null)
		{
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			try{
				model.Bullhorn cust = new Bullhorn();
				model.BullhornProfile profile = new BullhornProfile();
				
			String username= profile.getUsername();
			String fullname= profile.getUserFullname();
			String motto= profile.getUserMotto();
			String joined= profile.getJoinDate().toString();
			
            
			// get the list of values to display
			String person = "<table class=" 
					+ "\"table table-striped\"" 
					+ "style=width:60%>";

			person += 
					"<tr>" 
							+"<th>" + "Username" + "</th> <br>"
							+"<th>" + "Full Name" + "</th> <br>"
							+"<th>" + "Motto" + "</th> <br>"
							+"<th>" + "Date Joined" + "</th> <br>"
							+ "</tr>";
			
			person += "<tr>" 
					+"<td>" +username+"</td>"
					+"<td>" +fullname+"</td>"
					+"<td>" +motto+"</td>"
					+"<td>" +joined+"</td>"
					+"</tr>"
					;
			
			String line = "<table class=" 
	        		+ "\"table table-striped\"" 
	        		+ "style=width:60%>";
	        
	        line += 
	 			"<tr>" 
	 			+"<th>" + "Posts" + "</th> <br>"
	 			+"</tr>"
	 			;
		
	        for(int i=0; i<profile.getBullhorns().get(2).getPost().length();i++){
			
	        	line += "<tr>" 
	        			+"<td>" + Insert.selectPost().get(i).getPost()+ "</td>"
	        			+"</tr>"
	        	        ;
	        	}
	        
	        	line += "</table>";
			req.setAttribute("message", person);
			getServletContext().getRequestDispatcher("/Read.jsp").forward(req, res);
		}

	}
