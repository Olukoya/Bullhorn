import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Bullhorn;
import customTools.DBUtil;



public class Insert {

	public static void insert(Bullhorn user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
			em.persist(user);
			//em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public static List<Bullhorn>selectPost(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT b FROM Bullhorn b ORDER BY b.postDate DESC";
		TypedQuery<Bullhorn> q = em.createQuery(qString,Bullhorn.class);
		//q.setParameter("",username);
		//q.setParameter("",post);
		List <Bullhorn> custs;
		try{
			custs = q.getResultList();
			if (custs==null || custs.isEmpty())
				custs = null;
		} finally {
			em.close();
		}
		return custs;
	}
	
}
