package io.codeforall.fanstatics;


public class UserService {

    public String getUserById(int id) {

        // Logging manual
        System.out.println("Log (AOP): Método está prestes a ser executado.");
        System.out.println("Log: Método getUserById chamado com ID: " + id);
        System.out.println("Log (AOP): Método foi executado.");

        return "Utilizador com ID: " + id;
    }

    public String createUser(String name) {

        // Logging manual
        System.out.println("Log (AOP): Método está prestes a ser executado.");
        System.out.println("Log: Método createUser chamado com nome: " + name);
        System.out.println("Log (AOP): Método foi executado.");

        return "Utilizador criado: " + name;
    }
}
