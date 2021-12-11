package com.example.erp.controller;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.service.CourseService;
import com.example.erp.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("students")
public class StudentsController {
    StudentService studentService = new StudentService();
    CourseService courseService =  new CourseService();
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerStudent(Students student) throws URISyntaxException {
        System.out.println();
        List<Courses> courses = new ArrayList<>();
        Courses course1 = courseService.getCourseByID(student.getCourses().get(0).getCourse_id());
        Courses course2 = courseService.getCourseByID(student.getCourses().get(1).getCourse_id());

        if(course1!=null && course2 !=null){
            courses.add(course1);
            courses.add(course2);
            student.setCourses(courses);
            if(studentService.registerStudent(student)){
                return Response.ok().build();
            }else{
                return Response.status(203).build();
            }
        }
        return Response.status(203).build();

    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginStudent(Students student) throws URISyntaxException {
        Students result = studentService.verifyEmail(student);

        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result).build();
    }


    @POST
    @Path("/courseid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response studentcourse(Students student) throws URISyntaxException {

        List<Course_Schedule> courseslist = studentService.getCourse(student);
        System.out.println(courseslist.get(0).getTime());
        System.out.println(courseslist.get(0).getTime());

        if(courseslist.size()!=0)
        {
            return Response.ok().entity(courseslist).build();
        }
        else{
            return Response.status(203).build();
        }
    }
}
