import java.util.Scanner;

public class atv2 {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário para digitar um número
        System.out.print("Digite um número: ");

        // Lê o número digitado pelo usuário
        double numero = scanner.nextDouble();

        // Fecha o Scanner após a leitura
        scanner.close();

        // Verifica se o número é positivo, negativo ou zero e imprime a mensagem
        // correspondente
        if (numero > 0) {
            System.out.println("O número é positivo.");
        } else if (numero < 0) {
            System.out.println("O número é negativo.");
        } else {
            System.out.println("O número é zero.");
        }
    }
}
