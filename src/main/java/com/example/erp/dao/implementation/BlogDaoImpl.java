package com.example.erp.dao.implementation;

import com.example.erp.bean.Blogs;
import com.example.erp.dao.BlogDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BlogDaoImpl implements BlogDao {
    @Override
    public boolean registerBlog(Blogs blog) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(blog);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }




}