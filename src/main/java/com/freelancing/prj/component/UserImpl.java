/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancing.prj.component;

import com.freelancing.prj.persistance.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vinod
 */
@Component
public abstract class UserImpl implements UserRepositoryQ{

    @Override
    public User findByid(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
