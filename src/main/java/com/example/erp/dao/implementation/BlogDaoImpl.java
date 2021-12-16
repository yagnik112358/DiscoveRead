package com.example.erp.dao.implementation;

import com.example.erp.bean.Blogs;
import com.example.erp.dao.BlogDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    @Override
    public List<Blogs> getBlogs() {

        try (Session session = SessionUtil.getSession()) {
            return session.createQuery("select * from Blogs",Blogs.class).getResultList();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }

    }


}