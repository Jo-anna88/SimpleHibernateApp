package pl.simplehibernateapp;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Repository //Spring
public class ReaderRepository {
    //we use Fabric design pattern to create Entity Manager
    //createEntityManagerFactory - static method, which argument is 'name' from <persistence-unit> tag from persistence.xml
    //persistence-unit - we define them between tags <persistence>; it can be many of persistence-unit - everyone is responsible for one connection to db
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private static EntityManager em  = factory.createEntityManager(); //Singleton

    public void createReader(String name, int yearOfBirth) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin(); //transaction begin
        em.persist(new Reader(name, yearOfBirth));  //1) Entity Manager wysyła sygnał do Persistence Context, żeby nasz obiekt został w nim (P.C.) zapisany
                                                    //2) samo użycie tej metody oznacza póki co tylko pobranie nową sekwencji hibernate_sequence z puli ID i przypisanie jej dla naszego obiektu
        transaction.commit(); //transaction submitted -> send data to DB
    }

    public Reader getById(long id) {
        return em.find(Reader.class, id);
    }

    public void deleteById(long id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.find(Reader.class,id));
        transaction.commit();
        System.out.println("reader deleted");
    }

    public void updateYearById(long id, int y){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.find(Reader.class,id).setYearOfBirth(y);
        transaction.commit();
    }
}
