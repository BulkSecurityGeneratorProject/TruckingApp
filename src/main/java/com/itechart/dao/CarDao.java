package com.itechart.dao;


import com.itechart.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {

    List<Car> findAll();

    List<Car> findAllByPage(int offset, int recordPerPage);

    Optional<Car> findOne(int id);
}
