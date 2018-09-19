import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import lti.ex7.Bid;
import lti.ex7.Category;
import lti.ex7.Customer;
import lti.ex7.Item;
import lti.util.HibernateUtil;

public class CustomerTest {

	@Test
	public void testCase1() {

		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Item item1 = new Item();
		item1.setName("Chair");
		item1.setInitialPrice(2500);
		item1.setMaxBidAmount(5000.0);
		item1.setReservePrice(3000);
		item1.setTotalBids(120.0);
		item1.setValidTill(new Date());

		Item item2 = new Item();
		item2.setName("Table");
		item2.setInitialPrice(3500);
		item2.setMaxBidAmount(8000.0);
		item2.setReservePrice(2000);
		item2.setTotalBids(150.0);
		item2.setValidTill(new Date());

		Set<Item> itemSet = new HashSet<Item>();
		itemSet.add(item1);
		itemSet.add(item2);
		Category mainCat = new Category();
		mainCat.setName("Furniture");
		mainCat.setParentCategory(null);

		Category childCat = new Category();
		childCat.setName("Wooden Furniture");
		childCat.setParentCategory(mainCat);
		childCat.setItems(itemSet);

		Customer cust1 = new Customer();
		cust1.setName("Polo");
		System.out.println("Customer 1 is created... ");

		Customer cust2 = new Customer();
		cust2.setName("Lili");
		System.out.println("Customer 2 is created..");

		Bid bid1 = new Bid();
		bid1.setAmount(1500);
		bid1.setItem(item1);
		bid1.setCustomer(cust1);

		Bid bid2 = new Bid();
		bid2.setItem(item2);
		bid2.setAmount(1700);
		bid2.setCustomer(cust2);

		item1.getBids().add(bid1);

		item2.getBids().add(bid2);

		session.save(cust1);
		session.save(cust2);

		session.save(item1);
		session.save(item2);

		session.save(mainCat);
		session.save(childCat);

		session.save(bid1);
		session.save(bid2);
		
		tx.commit();
		
		factory.close();
		
	}

}
