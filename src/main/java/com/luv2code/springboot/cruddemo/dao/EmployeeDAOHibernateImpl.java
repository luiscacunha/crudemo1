package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entityManager
    private EntityManager entityManager;


    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        //Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }
}
