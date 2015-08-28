import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.persistence.*;

import javax.persistence.EntityManager;

import model.BullhornProfile;
import customTools.DBUtil;

public class grabUser {
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Bullhorn cust = em.find(model.Bullhorn.class, (long)2);
			System.out.println(cust.getPost());
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}
	}


public static boolean validity (String username, String password) {
	String userMessage = "SELECT p FROM BullhornProfile p WHERE p.username = :username and p.userPassword = :password";
	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	TypedQuery<BullhornProfile> user = em.createQuery(userMessage,BullhornProfile.class);
	
	user.setParameter("username", username);
	user.setParameter("password", password);

	boolean valid = false;
	try {
		
		if (user.getSingleResult().getUsername().equalsIgnoreCase(username) &&	user.getSingleResult().getUserPassword().equals(password))
		{
			valid = true;
		}	
		System.out.println(valid);
		
	} catch (Exception e){
		System.out.println(e);
	} finally {
		em.close();
	}
	return valid;
	
	
}

}