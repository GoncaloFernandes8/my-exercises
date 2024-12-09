package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        // Criar SecurityGroups
        SecurityGroup group1 = new SecurityGroup();
        group1.setName("Admin");

        SecurityGroup group2 = new SecurityGroup();
        group2.setName("User");

        User user1 = new User();
        User user2 = new User();

        user1.setName("John Doe");
        user2.setName("Jane Dasasae");

        user1.setSecurityGroups(new ArrayList<>());
        user2.setSecurityGroups(new ArrayList<>());

        user1.getSecurityGroups().add(group1);
        user2.getSecurityGroups().add(group2);

        // Persistir Users (automaticamente persiste os SecurityGroups)
        em.getTransaction().begin();
        em.persist(user1);
        em.persist(user2);
        em.persist(group1);
        em.persist(group2);
        em.getTransaction().commit();

        em.find(User.class, 1).getSecurityGroups().forEach(System.out::println); // Imprime os SecurityGroups do User 1

        em.close();
        emf.close();
    }
}
