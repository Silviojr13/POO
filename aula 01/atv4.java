import java.util.Scanner;

public class atv4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite sua idade:");

        int idade = scanner.nextInt();

        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade.");
        }

        scanner.close();
    }
}
