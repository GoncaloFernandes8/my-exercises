package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        // Create a new car and set its make, model, and owner
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Camry");

        Owner owner = new Owner();
        owner.setName("John Doe");

        // Set the owner of the car
        car.setOwner(owner);

        // Save the car and owner to the database
        EntityManager em = Persistence.createEntityManagerFactory("test").createEntityManager();

        em.getTransaction().begin();
        em.persist(car);
        em.persist(owner);
        em.getTransaction().commit();



        // Print the car and owner details
        System.out.println("Car:");


    }
}