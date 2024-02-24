// primeira parte em aula 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Digite seu nome:");
        String palavra = scan.next();
        System.out.printf("Seu nome é: " + palavra);
        scan.close();
    }
}