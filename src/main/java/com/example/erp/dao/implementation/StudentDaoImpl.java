package com.example.erp.dao.implementation;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Students emailVerify(Students student) {
        try (Session session = SessionUtil.getSession()) {
            session.setProperty("id",student.getEmail());
            Query query = session.createQuery("from Students where email=:email");
            query.setParameter("email", student.getEmail());

            for(final Object fetch: query.list())
            {
                return (Students) fetch;
            }

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public boolean registerStudent(Students student) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public List<Course_Schedule> getCourse(Students student){
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Students where email=:email");
            query.setParameter("email", student.getEmail());

            for (final Object fetch : query.list()) {
                Students obj = (Students) fetch;
                int c1 = obj.getCourses().get(0).getCourse_id();


                Query query1 = session.createQuery("from Course_Schedule where course_id=:c1");
                query1.setParameter("c1", c1);
                List<Course_Schedule> ret = new ArrayList<>();
                for (final Object fetch1 : query1.list()) {
                    Course_Schedule obj1 = (Course_Schedule) fetch1;
                    ret.add(obj1);
                    System.out.println(obj1.getDay());
                    System.out.println(obj1.getTime());
                    System.out.println(obj1.getCourse_name());
                }

                int c2 = obj.getCourses().get(1).getCourse_id();

                Query query2 = session.createQuery("from Course_Schedule where course_id=:c2");
                query2.setParameter("c2", c2);

                for (final Object fetch1 : query2.list()) {
                    Course_Schedule obj2 = (Course_Schedule) fetch1;
                    ret.add(obj2);
                    System.out.println(obj2.getDay());
                    System.out.println(obj2.getTime());
                    System.out.println(obj2.getCourse_name());
                }
                return ret;
            }
        }catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
