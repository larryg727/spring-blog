package com.codeup.Repositories;

import com.codeup.Model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by larryg on 6/22/17.
 */
public interface UsersRepostitory extends CrudRepository<User, Long> {
}
