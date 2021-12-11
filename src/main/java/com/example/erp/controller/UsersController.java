package com.example.erp.controller;

import com.example.erp.bean.Users;
import com.example.erp.service.BlogService;
import com.example.erp.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("students")
public class UsersController {
    UserService userService = new UserService();
    BlogService blogService =  new BlogService();


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
