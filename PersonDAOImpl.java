package ru.javastudy.hibernate.dao.implementations;

import org.hibernate.Session;
import ru.javastudy.hibernate.dao.PersonEntity;
import ru.javastudy.hibernate.dao.StudentEntity;
import ru.javastudy.hibernate.dao.interfaces.PersonDAO;

import java.util.List;

public abstract class PersonDAOImpl implements PersonDAO {

    private Session session;

    public List<PersonEntity> findAll() {
        return session.createQuery("from PersonEntity c").list();
    }

    public List<PersonEntity> findAllWithDetail() {
        return null;
    }

    public PersonEntity findById(Long id) {
        return null;
    }

    public PersonEntity save(PersonEntity student) {
        return null;
    }

    public void delete(PersonEntity student) {
    }

    public List<StudentEntity> deleteAll() {
        return null;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }
}
