package com.codeup.Repositories;

import com.codeup.Model.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by larryg on 6/21/17.
 */
public interface PostsRepository extends CrudRepository<Post, Long> {
}
