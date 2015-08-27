import javax.persistence.EntityManager;
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
}
