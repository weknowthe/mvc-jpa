package com.freelancing.prj.repositories;

import com.freelancing.prj.persistance.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface UserRepositoryQ extends CrudRepository<User, Integer>{    

    /**
     *
     * @param Id
     * @return
     */
    public User findByid(int Id);
}
