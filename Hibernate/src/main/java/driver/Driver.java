package driver;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.User;

public class Driver {
	
	//creating configuration object
	/*
	 * Configuration cfg=new Configuration();
	 * cfg.configure("hibernate.cfg.xml");//populates the data of the configuration
	 * file
	 * 
	 * //creating seession factory object try { SessionFactory
	 * factory=cfg.buildSessionFactory(); Session session=factory.openSession();
	 * 
	 * //creating transaction object Transaction t=session.beginTransaction();
	 * 
	 * User e1=new User();
	 * 
	 * e1.setName("sonoo"); e1.setCity("jaiswal");
	 * 
	 * session.persist(e1);//persisting the object
	 * 
	 * t.commit();//transaction is commited session.close();
	 * 
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * 
	 * 
	 * //creating session object System.out.println("successfully saved");
	 * 
	 */
	
	private static SessionFactory factory;
	public static void main(String[] args) {
		try {
//			factory= new Configuration().configure().buildSessionFactory();
			 factory = new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			System.out.println("Fails to create session factory object" + ex);
			// TODO: handle exception
			throw new ExceptionInInitializerError(ex);
		}
		
		User user= new User();
		user.setFname("vishal Gupta");
		user.setLname("Gupta");
		user.setCity("Ahmedabad");
		
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//session.save(user);
			session.persist(user);
			
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();
		}
		
	}

}
