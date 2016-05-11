package edu.umsl.sunnyDaysATM.dao;

import edu.umsl.sunnyDaysATM.domain.Account;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by genebrowder on 5/11/16.
 */
public class AccountDao {

    public static long saveAccount(Account account) {

        Session session = getSession();
        Transaction tx = null;
        long accountID = 0;
        try {
            tx = session.beginTransaction();

            accountID = (long) session.save(account);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return accountID;
    }

    private static Session getSession() {
        //Hibernate Code  ----------------------------------------------------------

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        //Hibernate Code  ----------------------------------------------------------

        SessionFactory factory = new Configuration().configure().buildSessionFactory(serviceRegistry);

        //Hibernate Code  ----------------------------------------------------------

        return factory.openSession();
    }

}
