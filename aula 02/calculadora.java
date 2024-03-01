import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o primeiro valor: ");
            int firstValue = s.nextInt();
            System.out.println("Digite o segundo valor: ");
            int secondValue = s.nextInt();
            System.out.println("Digite qual operaçao quer realizar(-,+,*,/): ");
            String operacao = s.next();
            int returnValue = 0;
            if (operacao.equals("+")) {
                returnValue = firstValue + secondValue;
            } else if (operacao.equals("-")) {
                returnValue = firstValue - secondValue;
            } else if (operacao.equals("*")) {
                returnValue = firstValue * secondValue;
            } else if (operacao.equals("/")) {
                returnValue = firstValue / secondValue;
            }
            System.out.println("O resultado da operaçao é " + returnValue);
            System.out.println("Deseja sair da calculadora? (s para sim)");
            String valueContinue = s.next();
            if (valueContinue.equals("s")) {
                break;
            }
        }
    }
}