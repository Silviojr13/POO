import java.util.Scanner;

public class atv3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite um numero: ");
        int numero1 = scan.nextInt();

        System.out.printf("Digite um segundo numero: ");
        int numero2 = scan.nextInt();

        System.out.printf("Digite um terceiro numero: ");
        int numero3 = scan.nextInt();

        double media = (numero1 + numero2 + numero3) / 3.0;

        System.out.println("A média dos números é: " + media);

        scan.close();

    }
}
