package com.codeup.Svc;

import com.codeup.Model.Post;
import com.codeup.Repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by larryg on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private PostsRepository postsDao;


@Autowired
public PostSvc(PostsRepository postsDao) {
    this.postsDao = postsDao;

}

    public Iterable<Post> findAll() {
    return postsDao.findAll();
    }

    public void save(Post post) {
        postsDao.save(post);
    }

    public Post findOne(long id) {
        return postsDao.findOne(id);
    }

    public void deletePost(long id) {
     postsDao.delete(id);
    }

    public Iterable<Post> findByUser(long id) {
    return postsDao.findPostsByUserId(id);
    }





}
