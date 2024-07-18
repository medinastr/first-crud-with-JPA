package com.medinastrr.cruddemo.dao;

import com.medinastrr.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
