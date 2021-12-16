package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Blogs")
public class Blogs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blog_id;
    private String name;
    private String description;
    private Integer userid;


//    private List<Users> users;

    public Blogs() {
    }

    public Blogs(String name, String description) {
        this.name = name;
        this.description = description;

    }
public Integer getBlog_id()
{return blog_id;}

    public void setBlog_id(Integer blog_id) {
        this.blog_id = blog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserid(){return userid;}
    public void setUserid(Integer id){this.userid=id;}

  /*  @JsonbTransient
    public List<Users> getUsers() {
        return users;
    }
*/
    /*public void setUsers(List<Users> users) {
        this.users=users;
    }*/
}
