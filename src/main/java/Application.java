import domain.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Message message = new Message("Hello world");
        Long id = (Long) session.save(message);

        transaction.commit();
        session.close();

        Session secondSession = HibernateUtil.getSessionFactory().openSession();
        Transaction secondTransaction = secondSession.beginTransaction();

        List messages = secondSession.createQuery("FROM domain.Message m ORDER BY m.text asc").list();

        System.out.println(messages.size() + " message(s) found:");
        for (Object item : messages) {
            System.out.println(((Message) item).getText());
        }

        secondTransaction.commit();
        secondSession.close();
        HibernateUtil.shutdown();
    }

}
