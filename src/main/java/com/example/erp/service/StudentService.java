package com.example.erp.service;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentDao;
import com.example.erp.dao.implementation.StudentDaoImpl;

import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    public Students verifyEmail(Students student){
        return studentDao.emailVerify(student);
    }

    public boolean registerStudent(Students student){
        return studentDao.registerStudent(student);
    }

    public List<Course_Schedule> getCourse(Students student){return studentDao.getCourse(student);}

}
