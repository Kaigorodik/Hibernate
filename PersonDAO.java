package ru.javastudy.hibernate.dao.interfaces;

import ru.javastudy.hibernate.dao.PersonEntity;
import ru.javastudy.hibernate.dao.StudentEntity;

import java.util.List;


public interface PersonDAO {

    // String hql = "FROM person";
    // Query query = session.createQuery("FROM person WHERE INSTR (LOWER (firstName, lastName, middleName), 'а') > 0);
    //List<PersonEntity> persons = query.list();

    // String hql = "FROM student";
    // Query query = session.createQuery("FROM student WHERE recordBook_id IS NULL);
    //       List<StudentEntity> students = query.list();


    // Найти все контакты.
    public List<PersonEntity> findAll();

    // Найти все контакты с заданным телефоном и хобби.
    public List<PersonEntity> findAllWithDetail();

    // Найти контакт со всеми деталями по идентификатору.
    public PersonEntity findById(Long id);

    // Вставить или обновить контакт.
    public PersonEntity save(PersonEntity person);

    // Удалить контакт.
    public void deleteAll(StudentEntity student);
}