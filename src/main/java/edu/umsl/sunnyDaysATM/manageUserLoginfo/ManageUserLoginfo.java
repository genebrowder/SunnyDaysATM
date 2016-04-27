package edu.umsl.sunnyDaysATM.manageUserLoginfo;

import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by genebrowder on 3/19/16.
 */
public class ManageUserLoginfo {

    private static SessionFactory factory;

    public static boolean isValiduser(UserLoginInfo UserLoginInfo){
        List<UserLoginInfo> alluserLoginInfoList =   getAllUserLoginInfo();

        for(UserLoginInfo userLogininfo: alluserLoginInfoList)   {

            if ((UserLoginInfo.getAccountNumber().equals(userLogininfo.getAccountNumber()))  &&
                    (UserLoginInfo.getPin().equals(userLogininfo.getPin()))  ){

                return true;
            }
        }

        return false;

    }
    private static List getAllUserLoginInfo(){

        //Hibernate Code  ----------------------------------------------------------

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(configuration.getProperties());

        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        //Hibernate Code  ----------------------------------------------------------

        factory= new Configuration().configure().buildSessionFactory(serviceRegistry);

        //Hibernate Code  ----------------------------------------------------------

        Session session = factory.openSession();

        Transaction tx = null;

        List allUserLoginInfoList = new ArrayList();
        try{
            tx = session.beginTransaction();

            Query queryResult = session.createQuery("from UserLoginInfo");


            allUserLoginInfoList = queryResult.list();
            for (int i = 0; i < allUserLoginInfoList.size(); i++) {
                UserLoginInfo userLoginInfo = (UserLoginInfo) allUserLoginInfoList.get(i);
                System.out.println("userLoginInfo["+userLoginInfo.getId()+"] account ="+userLoginInfo.getAccountNumber());
                System.out.println("userLoginInfo["+userLoginInfo.getId()+"] address ="+userLoginInfo.getPin());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return allUserLoginInfoList;
    }

}
