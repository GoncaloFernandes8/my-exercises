package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");


        // Open a new database connection by getting a new
        // EntityManager instance from the EntityManagerFactory.
        EntityManager em = emf.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();


        // Create a new category instance
        Category category1 = new Category();
        category1.setName("shampoo");

        // Create a new Product instance
        Product product = new Product();
        product.setName("Product 1");

        Product product2 = new Product();
        product2.setName("Product 2");


        em.persist(category1);
        em.persist(product);
        em.persist(product2);

        product.setCategory(category1);
        product2.setCategory(category1);


        em.getTransaction().commit();


        System.out.println("ola");


        em.close();
        emf.close();


    }

}