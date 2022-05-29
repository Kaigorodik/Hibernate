package ru.javastudy.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.javastudy.hibernate.dao.RecordBookEntity;
import ru.javastudy.hibernate.dao.PersonEntity;
import ru.javastudy.hibernate.dao.StudentEntity;
import ru.javastudy.hibernate.dao.implementations.PersonDAOImpl;
import ru.javastudy.hibernate.dao.interfaces.PersonDAO;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class AppMain {

    @PersistenceUnit
    static EntityManager emf;

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity();

        personEntity.setPerson_id(23);
        personEntity.setPassportSeries(6505);
        personEntity.setPassportNumber(133649);
        personEntity.setFirstName("Ivan");
        personEntity.setMiddleNameName("Ivanovich");
        personEntity.setLastName("Petrov");
        session.save(personEntity);

        RecordBookEntity recordBookEntity = new RecordBookEntity();
        recordBookEntity.setRecordBook_id(6789);
        recordBookEntity.setCode(12345);
        session.save(recordBookEntity);

        StudentEntity student = new StudentEntity();

        student.getPerson();
        student.getRecordBook();
        student.setGroup("RIM 110971");
        session.save(student);

        session.getTransaction().commit();

//        Query query = session.createQuery("from ContactEntity where firstName = :paramName");
//        query.setParameter("paramName", "Nick");
//        List list = query.list();

        PersonDAOImpl PersonDAO = new PersonDAOImpl() {
            public void deleteAll(StudentEntity student) {
                System.out.println("Все студенты удалены");
            }
        };
        PersonDAO.setSession(session);

        Transaction tx = session.beginTransaction();

        List<PersonEntity> person = PersonDAO.findAll();
        for (PersonEntity person : person) {
            System.out.println(person);
        }

        listPerson(person);

        tx.commit();
        session.close();

    }

    private static void listPerson(List<PersonEntity> person) {
        System.out.println("Person with detail info");
        for (PersonEntity person: person) {
            System.out.println(person);
            if (person.getStudent() != null) {
                for (StudentEntity student : person.getStudent() {
                    System.out.println(person);
                }
            }
        }
    }

}
