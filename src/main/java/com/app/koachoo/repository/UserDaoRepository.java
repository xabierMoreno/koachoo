package com.app.koachoo.repository;

import com.app.koachoo.dao.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}
