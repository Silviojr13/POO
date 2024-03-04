import java.util.Scanner;

public class PBL2 {
    private static final int NUM_PLAYERS = 5; // Número de jogadores
    private static final int NUM_LEVELS = 3; // Número de níveis

    private static String[] playerNames = new String[NUM_PLAYERS];
    private static int[] playerScores = new int[NUM_PLAYERS];
    private static int[][] coinsCollected = new int[NUM_PLAYERS][NUM_LEVELS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Adicionar jogadores
        addPlayer(0, "Player1", 0, new int[] { 10, 20, 30 });
        addPlayer(1, "Player2", 0, new int[] { 15, 25, 35 });
        addPlayer(2, "Player3", 0, new int[] { 20, 30, 40 });
        addPlayer(3, "Player4", 0, new int[] { 25, 35, 45 });
        addPlayer(4, "Player5", 0, new int[] { 30, 40, 50 });

        // Mostrar opções para o usuário
        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("a) Adicionar novo jogador");
            System.out.println("b) Atualizar pontuação de um jogador");
            System.out.println("c) Mostrar pontuação total de um jogador");
            System.out.println("d) Mostrar total de moedas coletadas em um nível");
            System.out.println("e) Mostrar jogador com a pontuação mais alta");
            System.out.println("x) Sair");

            String option = scanner.nextLine();

            switch (option) {
                case "a":
                    addNewPlayer(scanner);
                    break;
                case "b":
                    updatePlayerScore(scanner);
                    break;
                case "c":
                    showPlayerTotalScore(scanner);
                    break;
                case "d":
                    showTotalCoinsCollected(scanner);
                    break;
                case "e":
                    showPlayerWithHighestScore();
                    break;
                case "x":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Adicionar novo jogador
    private static void addPlayer(int index, String name, int score, int[] coins) {
        playerNames[index] = name;
        playerScores[index] = score;
        coinsCollected[index] = coins;
    }

    private static void addNewPlayer(Scanner scanner) {
        System.out.println("Digite o nome do novo jogador:");
        String name = scanner.nextLine();

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (playerNames[i] == null) {
                System.out.println("Digite a pontuação inicial para o jogador:");
                int score = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite a quantidade de moedas coletadas em cada nível separadas por espaço:");
                String[] coinsStr = scanner.nextLine().split(" ");
                int[] coins = new int[NUM_LEVELS];
                for (int j = 0; j < NUM_LEVELS; j++) {
                    coins[j] = Integer.parseInt(coinsStr[j]);
                }
                addPlayer(i, name, score, coins);
                System.out.println("Novo jogador adicionado com sucesso!");
                return;
            }
        }
        System.out.println("Número máximo de jogadores alcançado.");
    }

    // Atualizar pontuação de um jogador após a conclusão de um nível
    private static void updatePlayerScore(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String name = scanner.nextLine();
        System.out.println("Digite a pontuação do jogador após o nível:");
        int score = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (playerNames[i] != null && playerNames[i].equalsIgnoreCase(name)) {
                playerScores[i] = score;
                System.out.println("Pontuação atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Jogador não encontrado.");
    }

    // Mostrar pontuação total de um jogador
    private static void showPlayerTotalScore(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String name = scanner.nextLine();

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (playerNames[i] != null && playerNames[i].equalsIgnoreCase(name)) {
                System.out.println("Pontuação total de " + name + ": " + playerScores[i]);
                return;
            }
        }
        System.out.println("Jogador não encontrado.");
    }

    // Mostrar total de moedas coletadas em um nível
    private static void showTotalCoinsCollected(Scanner scanner) {
        System.out.println("Digite o número do nível:");
        int level = Integer.parseInt(scanner.nextLine());
        int totalCoins = 0;

        for (int[] coins : coinsCollected) {
            totalCoins += coins[level - 1];
        }

        System.out.println("Total de moedas coletadas no nível " + level + ": " + totalCoins);
    }

    // Mostrar jogador com a pontuação mais alta
    private static void showPlayerWithHighestScore() {
        int maxScore = Integer.MIN_VALUE;
        String playerName = "";

        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (playerNames[i] != null && playerScores[i] > maxScore) {
                maxScore = playerScores[i];
                playerName = playerNames[i];
            }
        }

        System.out.println("O jogador com a pontuação mais alta é: " + playerName + " com " + maxScore + " pontos.");
    }
}
