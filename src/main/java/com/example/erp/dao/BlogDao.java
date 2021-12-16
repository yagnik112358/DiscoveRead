package com.example.erp.dao;

import com.example.erp.bean.Blogs;

import java.util.List;

public interface BlogDao {
    boolean registerBlog(Blogs blog);

    List<Blogs> getBlogs();
}
