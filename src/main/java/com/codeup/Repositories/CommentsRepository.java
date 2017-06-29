package com.codeup.Repositories;

import com.codeup.Model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by larryg on 6/29/17.
 */
public interface CommentsRepository extends CrudRepository<Comment, Long> {
}
