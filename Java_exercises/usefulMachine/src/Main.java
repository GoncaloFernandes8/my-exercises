public class Main {
    public static void main(String[] args) {
        // Operações com Números
        MonoOperation<Integer> square = x -> x * x;
        BiOperation<Integer> add = (x, y) -> x + y;

        int number = 5;
        System.out.println("Square of " + number + ": " + Machine.performMonoOperation(number, square));
        System.out.println("Addition of 5 and 10: " + Machine.performBiOperation(5, 10, add));



        /*
        ===========================================================
         */




        // Operações com Strings
        MonoOperation<String> toUpperCase = String::toUpperCase;
        BiOperation<String> concatenate = (s1, s2) -> s1 + " " + s2;

        String str1 = "hello";
        String str2 = "world";
        System.out.println("Uppercase of '" + str1 + "': " + Machine.performMonoOperation(str1, toUpperCase));
        System.out.println("Concatenation: " + Machine.performBiOperation(str1, str2, concatenate));



        /*
        ===========================================================
         */



        // Operações com Objetos de escolha (Exemplo: Pessoa)
        MonoOperation<Person> celebrateBirthday = person -> {
            person.setAge(person.getAge() + 1);
            return person;
        };
        BiOperation<Person> mergeNames = (p1, p2) -> new Person(p1.getName() + " & " + p2.getName(), Math.max(p1.getAge(), p2.getAge()));

        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);

        System.out.println("Before birthday: " + person1);
        Machine.performMonoOperation(person1, celebrateBirthday);
        System.out.println("After birthday: " + person1);

        System.out.println("Merged people: " + Machine.performBiOperation(person1, person2, mergeNames));
    }
}



// Classe exemplo para operação com objetos
class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
