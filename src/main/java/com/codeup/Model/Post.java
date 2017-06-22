package com.codeup.Model;

import javax.persistence.*;

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
    private String title;

   @Column(nullable = false)
   private String body;

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
}
