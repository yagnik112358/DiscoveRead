package com.example.erp.service;

import com.example.erp.bean.Blogs;
import com.example.erp.dao.BlogDao;
import com.example.erp.dao.implementation.BlogDaoImpl;

public class BlogService {
    BlogDao blogDao = new BlogDaoImpl();
    public boolean registerBlog(Blogs blog){
        return blogDao.registerBlog(blog);
    }

}
