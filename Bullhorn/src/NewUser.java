

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
 * Servlet implementation class NewUser
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUser() {
        super();
        // TODO Auto-generated constructor stub
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

	//	HttpSession session = req.getSession();
	//	session.setAttribute("username", req.getParameter("username"));
	//	session.setAttribute("password", req.getParameter("password"));
		
	//	boolean login = grabUser.validity(req.getParameter("username"), req.getParameter("password"));
	//	if (login == true)
	//	{
	//		getServletContext().getRequestDispatcher("/Write.jsp").forward(req, res);
	//	}else
	//	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.BullhornProfile profile = new BullhornProfile();
		
		String username= req.getParameter("username");
		String password=  req.getParameter("password");
		String fullname= req.getParameter("fname");
		String motto=  req.getParameter("motto");
		Date joinDate = new Date();
		
		profile.setUsername(username);
		profile.setUserPassword(password);
		profile.setUserFullname(fullname);
		profile.setUserMotto(motto);
		profile.setJoinDate(joinDate);

		Insert.insertProfile(profile);
	//	}
		getServletContext().getRequestDispatcher("/Login.jsp").forward(req, res);
	}

}
