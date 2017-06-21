package com.codeup.Svc;

import com.codeup.Model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larryg on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {

private List<Post> posts = new ArrayList<>();

public PostSvc() {
   createPosts();
}

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    private List<Post> createPosts() {
        posts.add(new Post("some title here","some description here.. and more", (long) 1));
        posts.add(new Post("another title here", "another description here.. and  even more", (long) 2));
        posts.add(new Post("and a final here", "final description here.. and  lastly more", (long) 3));
        return posts;
    }


}
