package com.codeup.Repositories;

import com.codeup.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by larryg on 6/22/17.
 */
@Repository
public interface UsersRepostitory extends CrudRepository<User, Long> {
     public User findByUsername(String username);
}
