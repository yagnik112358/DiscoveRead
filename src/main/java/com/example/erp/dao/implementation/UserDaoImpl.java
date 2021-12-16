package com.example.erp.dao.implementation;

import com.example.erp.bean.Users;
import com.example.erp.dao.UserDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public Users emailVerify(Users user) {
        try (Session session = SessionUtil.getSession()) {
            session.setProperty("id",user.getEmail());
            Query query = session.createQuery("from Users where email=:email");
            query.setParameter("email", user.getEmail());
            System.out.println("email verified");

            Query query2 = session.createQuery("select user_id from Users where email=:email");
            query2.setParameter("email", user.getEmail());

            for(final Object fetch2: query2.list())
            {
                session.setProperty("userid",fetch2);
                //System.out.println(fetch2);
            }


            for(final Object fetch: query.list())
            {

                return (Users) fetch;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public boolean registerUser(Users user) {
        /*System.out.println(user.getEmail()+"Dao1");
        Session session = SessionUtil.getSession();
        System.out.println(user.getEmail()+"Dao2");
        Transaction transaction = session.beginTransaction();
        System.out.println(user.getEmail()+"Dao3");
        session.save(user);
        System.out.println(user.getEmail()+"Dao4");
        transaction.commit();
        System.out.println(user.getEmail()+"Dao5");
        return true;
*/
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
//            System.out.println(user.getEmail()+"Dao");
            session.save(user);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
//            System.out.print("Error");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }



}
