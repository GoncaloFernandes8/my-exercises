import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                         "I hope that someone garbage gets my message in a garbage bottle.";

        String messageResult = Arrays.stream(message.split(" "))

                .filter(word -> !word.equals("garbage"))
                .reduce("",(acc, ele)-> acc + ele + " ")
                .toUpperCase();

        System.out.println(messageResult);

    }
}
