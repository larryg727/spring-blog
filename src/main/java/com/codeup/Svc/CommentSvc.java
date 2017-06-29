package com.codeup.Svc;

import com.codeup.Model.Comment;
import com.codeup.Model.Post;
import com.codeup.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by larryg on 6/29/17.
 */
@Service("commentSvc")
public class CommentSvc {
    private CommentsRepository commentsDao;

    @Autowired
    public  CommentSvc(CommentsRepository commentsDao) {
        this.commentsDao = commentsDao;
    }

    public void save(Comment comment) {
        commentsDao.save(comment);
    }

    public List<Comment> allCommentsByPost(Post post) {
        return commentsDao.findCommentsByPost(post);
    }
}
