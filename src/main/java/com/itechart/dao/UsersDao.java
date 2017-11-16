package com.itechart.dao;


import com.itechart.domain.User;
import com.itechart.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UsersDao {

    List<Users> findAll();

    List<Users> findAllByPage(int offset, int recordPerPage);

    Optional<Users> findOne(int id);

    void save(Users user);

    void delete(Users user);

    void deleteById(int id);
}
