package com.freelancing.prj.component;

import com.freelancing.prj.persistance.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component
public interface UserRepositoryQ extends CrudRepository<User, Integer>{    

    /**
     *
     * @param Id
     * @return
     */
    public User findByid(int Id);
}
