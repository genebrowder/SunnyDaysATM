package edu.umsl.sunnyDaysATM.manageUser;

import edu.umsl.sunnyDaysATM.domain.User;
import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by genebrowder on 3/20/16.
 */
public class ManageUser {

    private static SessionFactory factory;

    public User getOneUser(UserLoginInfo userLoginInfo){

        //Hibernate Code  ----------------------------------------------------------

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        factory= new Configuration().configure().buildSessionFactory(serviceRegistry);

        //Hibernate Code  ----------------------------------------------------------

        Session session = factory.openSession();

        Transaction tx = null;

        List<UserLoginInfo> allUserLoginInfoList = new ArrayList();

        User user = null;

        try{
            tx = session.beginTransaction();

            Query queryResult = session.createQuery("from UserLoginInfo");


             allUserLoginInfoList = queryResult.list();

            long userId=0;

            for (UserLoginInfo userLoginInfoFromDatabase : allUserLoginInfoList) {
                System.out.println("userLoginInfo["+userLoginInfoFromDatabase.getId()+"] account ="+userLoginInfoFromDatabase.getAccountNumber());
                System.out.println("userLoginInfo["+userLoginInfoFromDatabase.getId()+"] address ="+userLoginInfoFromDatabase.getPin());

                if ((userLoginInfoFromDatabase.getAccountNumber().equals(userLoginInfo.getAccountNumber()))  &&
                        (userLoginInfoFromDatabase.getPin().equals(userLoginInfo.getPin()))  ){

                    userId = userLoginInfoFromDatabase.getId();
                }
            }

            user = (User) session.get(User.class, userId) ;

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return user;


    }


}
