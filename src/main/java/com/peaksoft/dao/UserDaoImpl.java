package com.peaksoft.dao;

import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.openSession().createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.openSession().save(user);

    }

    @Override
    public User getById(Integer id) {
        return sessionFactory.openSession().get(User.class,id);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);

    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().remove(user);

    }
}
