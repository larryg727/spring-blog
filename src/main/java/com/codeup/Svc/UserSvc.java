package com.codeup.Svc;
import com.codeup.Model.User;
import com.codeup.Repositories.UsersRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by larryg on 6/22/17.
 */
@Service("userSvc")
public class UserSvc {
    private UsersRepostitory userDao;

    @Autowired
    public UserSvc(UsersRepostitory userDao){
        this.userDao = userDao;
    }

    public User findOne(long id){
        return userDao.findOne(id);
    }
}
