package com.medinastrr.cruddemo.dao;

import com.medinastrr.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    // inject manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query and return query results
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create a query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:param", Student.class);

        // set query parameters
        query.setParameter("param", lastName);

        // return query results
        return query.getResultList();
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        // retrieve the student and delete student
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
