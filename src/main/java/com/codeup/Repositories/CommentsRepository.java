package com.codeup.Repositories;

import com.codeup.Model.Comment;
import com.codeup.Model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by larryg on 6/29/17.
 */
public interface CommentsRepository extends CrudRepository<Comment, Long> {
    public List<Comment> findCommentsByPost(Post post);
}
