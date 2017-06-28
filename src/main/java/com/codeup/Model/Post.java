package com.codeup.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by larryg on 6/19/17.
 */
@Entity
@Table(name = "posts")
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false, length = 100)
   @Size(min = 3, message = "Posts titles must be at least 3 characters.")
    private String title;

   @Column(nullable = false)
   @Size(min = 5, message = "Please create a longer post. Minimum of 5 characters.")
   private String body;

   @OneToOne
   @JsonManagedReference
   private User user;

   @Column
   private String imageUrl;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, String body, Long id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
