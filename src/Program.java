import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    private static final String VALUE_TO_QUIT = "9999";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Person> men = new HashSet<>();
        Set<Person> women = new HashSet<>();

        System.out.println("DIGITE " + VALUE_TO_QUIT + " PARA SAIR DO PROGRAMA");

        while (true) {
            String name, gender;

            System.out.print("\nInsira o nome de uma pessoa: ");
            name = sc.nextLine();

            if (checkIfShouldQuit(name)) break;

            do {
                System.out.print("Insira o seu sexo (M ou F): ");
                gender = sc.next();
            } while (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F") && !checkIfShouldQuit(gender));

            if (checkIfShouldQuit(name)) break;

            Person p = new Person(name, gender);
            String setType = p.getGender().equals("masculino") ? "dos HOMENS" : "das MULHERES";

            if (!men.contains(p) && !women.contains(p)) {

                if (p.getGender().equals("masculino"))
                    men.add(p);
                else women.add(p);

                System.out.println(
                        "\n" + p.getName().toUpperCase()
                                + " do sexo " + p.getGender().toUpperCase()
                                + " adicionad" + (p.getGender().equals("masculino") ? "o" : "a")
                                + " ao conjunto " + setType + ".\n"
                );
            } else
                System.out.println("\n" + p.getName().toUpperCase() + " já está inserido no conjunto " + setType + "!\n");

            System.out.println("Conjunto dos homens: " + men);
            System.out.println("Conjunto das mulheres: " + women);
            System.out.print("\nInsira qualquer valor para inserir outra pessoa ou " + VALUE_TO_QUIT + " para sair do programa: ");
            String input = sc.next();

            if (checkIfShouldQuit(input)) break;

            sc.nextLine();
        }
    }

    public static boolean checkIfShouldQuit(String input) {
        return (input.equals(VALUE_TO_QUIT));
    }
}
