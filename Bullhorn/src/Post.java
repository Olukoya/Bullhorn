

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
 * Servlet implementation class Post
 */
@WebServlet("/Post")
public class Post extends HttpServlet {
	static String use;
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
		
		
		HttpSession session = req.getSession();
		session.setAttribute("username", req.getParameter("username"));
		session.setAttribute("password", req.getParameter("password"));
		
		boolean login = grabUser.validity(req.getParameter("username"), req.getParameter("password"));
		if (login == true)
		{
			getServletContext().getRequestDispatcher("/Write.jsp").forward(req, res);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
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
		//  +"<td>"+"<a href =" + "\"Details?type=" +type+"\"" + ">" + type +"</a>"+"</td>"
        for(int i=0; i<Insert.selectPost().size(); i++){
		 use = Insert.selectPost().get(i).getBullhornProfile().getUsername();
		
        	line += "<tr>" 
        			+"<td>" +"<a href =" +"\"Read?use=" +use+"\""+">"+ use +"</a>"+"</td>"
        			+"<td>" + Insert.selectPost().get(i).getPost()+ "</td>"
        			+"</tr>"
        	        ;
        	}
        
        	line += "</table>";
		req.setAttribute("message", line);
		getServletContext().getRequestDispatcher("/Read.jsp").forward(req, res);
		
	}

	}


