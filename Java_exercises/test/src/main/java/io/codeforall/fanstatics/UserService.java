package io.codeforall.fanstatics;

public class UserService {

    public String getUserById(int id) {

        System.out.println();
        System.out.println("Executando lógica de `getUserById`...");
        System.out.println();
        return "Utilizador com ID: " + id;
    }

    public String createUser(String name) {

        System.out.println();
        System.out.println("Executando lógica de `createUser`...");
        System.out.println();
        return "Utilizador criado: " + name;
    }
}
