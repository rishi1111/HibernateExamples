import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.ex1.Product;
import lti.util.HibernateUtil;

public class TestProduct {

	@Test
	public void testFetchProduct() {

		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Product p = (Product) session.get(Product.class, 3);
		System.out.println(p.getName() + ":" + p.getPrice());
		factory.close();

	}

	@Test
	public void testUpdateProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();

		Product p = (Product) session.get(Product.class, 2);

		p.setPrice(10000); // update in attached scenario

		txn.commit();
		factory.close();

	}

	@Test
	public void testUpdateProductDetached() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();

		Product p = (Product) session.get(Product.class, 2);
		txn.commit();

		session = factory.getCurrentSession();
		txn = session.beginTransaction();

		p.setPrice(7777); // update in detached scenario
		session.update(p);
		txn.commit();
		factory.close();

	}
	@Test
	public void testDeleteProduct() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction txn = session.beginTransaction();
		
		Product p = (Product) session.get(Product.class, 2);
		session.delete(p);
		txn.commit();
		factory.close();
		
	}

	@Test
	public void testAddProduct() {
		SessionFactory factory = HibernateUtil.getFactory(); // represents a database

		Session session = factory.getCurrentSession();
		Transaction txn = session.getTransaction();

		Product p1 = new Product();
		p1.setName("iPhone 6");
		p1.setPrice(29999);

		try {
			txn.begin();
			session.save(p1);
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
		} finally {
			factory.close();
		}
	}

}
