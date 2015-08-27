

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bullhorn;
import customTools.DBUtil;

/**
 * Servlet implementation class Post
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		@SuppressWarnings("unused")
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Bullhorn cust = new Bullhorn();
		
		String username= req.getParameter("username");
		String comment=  req.getParameter("comment");
		Date today = new Date();
		cust.setUsername(username);
		cust.setPost(comment);
		cust.setPostDate(today);
		//hardcode password for testing
		cust.setUserPassword("password");
		Insert.insert(cust);
		
		
		// get the list of values to display
	    String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
        
        line += 
 			"<tr>" 
 			+"<th>" + "Username" + "</th> <br>"
 			+"<th>" + "Post" + "</th> <br>"
 			+ "</tr>"
 			;
		
        for(int i=0; i<Insert.selectPost().size(); i++){
			
		
        	line += "<tr>" 
        			+"<td>" + Insert.selectPost().get(i).getUsername()+ "</td>"
        			+"<td>" + Insert.selectPost().get(i).getPost()+ "</td>"
        			+"</tr>"
        	        ;
        	}
        
        	line += "</table>";
		req.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Read.jsp").forward(req, res);
		
	}

	}


