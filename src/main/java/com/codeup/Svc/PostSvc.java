package com.codeup.Svc;

import com.codeup.Model.Post;
import com.codeup.Repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by larryg on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private PostsRepository postsRepository;


@Autowired
public PostSvc(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;

}

    public Iterable<Post> findAll() {
    return postsRepository.findAll();
    }

    public void save(Post post) {
        postsRepository.save(post);
    }

    public Post findOne(long id) {
        return postsRepository.findOne(id);
    }




}
