import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {

    public static void main(String[] args) {

        try {
            SessionFactory sf =
                new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            for (int i = 0; i < 200; i++) {
                Customer customer = new Customer();
                customer.setUsername("customer" + i);
                customer.setPassword("customer");
                session.save(customer);
            }

            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
