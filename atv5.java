import java.util.Scanner;

public class atv5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os graus em Celsius: ");

        double graus = scanner.nextDouble();

        double num = 1.8;

        double soma = graus * num + 32;

        System.out.println("Em graus Fahrenheit é: " + soma);

        scanner.close();
    }

}
