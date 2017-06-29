package com.codeup.Svc;

import com.codeup.Model.Comment;
import com.codeup.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
