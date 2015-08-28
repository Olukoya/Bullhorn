

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bullhorn;
import model.BullhornProfile;
import customTools.DBUtil;

/**
 * Servlet implementation class ViewBulls
 */
@WebServlet("/ViewBulls")
public class ViewBulls extends HttpServlet {
	static String use;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBulls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	/*	HttpSession session = req.getSession();
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		model.Bullhorn cust = new Bullhorn();
		String username= (String) session.getAttribute("username");
		model.BullhornProfile profile2 = em.createQuery("select b from BullhornProfile b where b.username = :name",model.BullhornProfile.class).setParameter("name",username).getSingleResult();
		
		String post=  req.getParameter("comment");
		profile2.setUsername(username);
		Date postDate = new Date();
		
		cust.setBullhornProfile(profile2);
		cust.setPost(post);
		cust.setPostDate(postDate);
		cust.setBullhornProfile(profile2);
		Insert.insert(cust);
		
		*/
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.Bullhorn cust = new Bullhorn();
		// get the list of values to display
	    String line = "<table class=" 
        		+ "\"table table-striped\"" 
        		+ "style=width:60%>";
        
        line += 
 			"<tr>" 
 			+"<th>" + "Username" + "</th> <br>"
 			+"<th>" + "Posts" + "</th> <br>"
 			+ "</tr>"
 			;
		
        for(int i=0; i<Insert.selectPost().size(); i++){
        	 use = Insert.selectPost().get(i).getBullhornProfile().getUsername();
			
		
        	line += "<tr>" 
        			+"<td>" +"<a href =" +"\"Read?use=" +use+"\""+">"+ use +"</a>"+"</td>"
        			+"<td>" + Insert.selectPost().get(i).getPost()+ "</td>"
        			+"</tr>"
        	        ;
        	}
        
        	line += "</table>";
		req.setAttribute("all", line);
		getServletContext().getRequestDispatcher("/Read.jsp").forward(req, res);
		
	}

}
