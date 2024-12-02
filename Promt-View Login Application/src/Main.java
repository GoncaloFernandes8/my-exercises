import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        // Criando o Map com nome de utilizador e palavra-passe
        Map<String, String> users = new HashMap<>();
        users.put("user1", "123");
        users.put("admin", "adminpass");
        users.put("guest", "guestpass");

        Prompt prompt = new Prompt(System.in, System.out);



        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("What is your name? ");


        PasswordInputScanner question2 = new PasswordInputScanner();
        question2.setMessage("What is your password? ");




        String userName = prompt.getUserInput(question1);

        String userPassword = prompt.getUserInput(question2);



        // Verificando se o nome do utilizador e a palavra-passe estão corretos
        if (users.containsKey(userName) && users.get(userName).equals(userPassword)) {
            System.out.println("Welcome " + userName);

        } else {
            System.out.println(("Login failed! Incorrect username or password."));
        }
    }
}




