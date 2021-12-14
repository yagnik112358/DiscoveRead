package com.example.erp.controller;

import com.example.erp.bean.Blogs;
import com.example.erp.bean.Users;
import com.example.erp.service.BlogService;
import com.example.erp.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("blogs")
public class BlogsController {

    BlogService blogService =  new BlogService();


    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerBlog(Blogs blog) throws URISyntaxException {
        System.out.println(blog.getDescription()+"controller");

        {

            if(blogService.registerBlog(blog)){
                System.out.println(blog.getDescription()+"controller2");
                return Response.ok().build();
            }else{
                return Response.status(203).build();
            }
        }


    }



    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(Users user) throws URISyntaxException {
        Users result = UserService.verifyEmail(user);

        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }



}
