package com.codeup.Svc;


import com.codeup.Model.User;
import com.codeup.Model.UserRole;
import com.codeup.Repositories.RolesRepository;
import com.codeup.Repositories.UsersRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by larryg on 6/23/17.
 */

@Service("customUserDetailsService")
public class UserDetailsLoader implements UserDetailsService {
    private final UsersRepostitory users;
    private final RolesRepository roles;

    @Autowired
    public UserDetailsLoader(UsersRepostitory users, RolesRepository roles) {
        this.users = users;
        this.roles = roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        List<String> userRoles = roles.ofUserWith(username);
        return new UserWithRoles(user, userRoles);
    }
}