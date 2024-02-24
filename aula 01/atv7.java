import java.util.Random;
import java.util.Scanner;

public class atv7 {
    public static void main(String[] args) {

        String[] opcoes = { "pedra", "papel", "tesoura" };

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        while (true) {

            System.out.println("Escolha: pedra, papel ou tesoura (ou digite 'sair' para encerrar o jogo):");
            String escolhaUsuario = scanner.nextLine().toLowerCase();

            if (escolhaUsuario.equals("sair")) {
                break;
            }

            if (!escolhaUsuario.equals("pedra") && !escolhaUsuario.equals("papel")
                    && !escolhaUsuario.equals("tesoura")) {
                System.out.println("Escolha inválida. Por favor, escolha entre pedra, papel ou tesoura.");
                continue;
            }

            int indiceEscolhaComputador = random.nextInt(opcoes.length);
            String escolhaComputador = opcoes[indiceEscolhaComputador];

            System.out.println("Você escolheu: " + escolhaUsuario);
            System.out.println("O computador escolheu: " + escolhaComputador);

            if (escolhaUsuario.equals(escolhaComputador)) {
                System.out.println("Empate!");
            } else if ((escolhaUsuario.equals("pedra") && escolhaComputador.equals("tesoura")) ||
                    (escolhaUsuario.equals("papel") && escolhaComputador.equals("pedra")) ||
                    (escolhaUsuario.equals("tesoura") && escolhaComputador.equals("papel"))) {
                System.out.println("Você ganhou!");
            } else {
                System.out.println("Você perdeu!");
            }
        }

        scanner.close();
    }
}
