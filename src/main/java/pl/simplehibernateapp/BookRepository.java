package pl.simplehibernateapp;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository //Spring
public class BookRepository {
    private EntityManager em;
    public BookRepository(EntityManager em) {
        this.em = em;
    }
//    public void createReservation(Guest guests) {
//        Reservation r = new Reservation(guests);
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.persist(r);
//        transaction.commit();

    }
