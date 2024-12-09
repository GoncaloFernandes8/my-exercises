package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

// Open a new database connection by getting a new
// entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();

        Customer customer = new Customer();
        Customer customer2 = new Customer();
        Account account = new Account();

        customer.setName("John Doe");
        customer.setCreationTime(new Date());
        customer.setUpdateTime(new Date());

        customer2.setName("Johnaaaaaa");
        customer2.setCreationTime(new Date());
        customer2.setUpdateTime(new Date());

        account.setBalance(1000.0);
        account.setCreationTime(new Date());
        account.setUpdateTime(new Date());


        em.getTransaction().begin();
        em.persist(account);
        em.persist(customer);
        em.persist(customer2);
        em.getTransaction().commit();

// Used to test the database connection, should return 2
        System.out.println("Result: " +
                           em.createNativeQuery("select 1 + 1").getSingleResult());

// Close the database connection
        em.close();

// Shutdown JPA
        emf.close();




    }


}