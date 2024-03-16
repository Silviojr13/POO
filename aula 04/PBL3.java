import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Conta {
    private String nomeTitular; // Declaração do atributo nomeTitular da classe Conta
    private int numero; // Declaração do atributo numero da classe Conta
    private double saldo; // Declaração do atributo saldo da classe Conta

    public Conta(String nomeTitular, int numero, double saldo) { // Declaração do construtor da classe Conta
        this.nomeTitular = nomeTitular; // Inicialização do atributo nomeTitular com o valor do parâmetro
        this.numero = numero; // Inicialização do atributo numero com o valor do parâmetro
        this.saldo = saldo; // Inicialização do atributo saldo com o valor do parâmetro
    }

    public int getNumero() { // Método para obter o número da conta
        return numero; // Retorna o número da conta
    }

    public double getSaldo() { // Método para obter o saldo da conta
        return saldo; // Retorna o saldo da conta
    }

    public String getNomeTitular() { // Método para obter o nome do titular da conta
        return nomeTitular; // Retorna o nome do titular da conta
    }

    public void setNomeTitular(String nomeTitular) { // Método para definir o nome do titular da conta
        this.nomeTitular = nomeTitular; // Define o nome do titular da conta com o valor do parâmetro
    }

    public boolean sacar(double valor) { // Método para realizar um saque
        if (valor > saldo) { // Verifica se o valor do saque é maior que o saldo disponível
            System.out.println("Saldo insuficiente."); // Imprime mensagem de saldo insuficiente
            return false; // Retorna false indicando que o saque não foi efetuado
        } else {
            saldo -= valor; // Subtrai o valor do saque do saldo
            System.out.println("Saque efetuado com sucesso. Novo saldo: " + saldo); // Imprime mensagem de saque efetuado com sucesso
            return true; // Retorna true indicando que o saque foi efetuado
        }
    }

    public void depositar(double valor) { // Método para realizar um depósito
        saldo += valor; // Adiciona o valor do depósito ao saldo
        System.out.println("Depósito efetuado com sucesso. Novo saldo: " + saldo); // Imprime mensagem de depósito efetuado com sucesso
    }
}

public class PBL3 {
    private static final String ARQUIVO_CONTAS = "contas.txt"; // Declaração da constante ARQUIVO_CONTAS que representa o nome do arquivo de contas

    public static void main(String[] args) {
        ArrayList<Conta> contas = carregarContas(); // Carrega as contas do arquivo

        try (Scanner scanner = new Scanner(System.in)) { // Início do bloco try-with-resources para utilizar o Scanner
            int opcao; // Declaração da variável opcao

            do { // Início do loop do-while
                System.out.println("Escolha uma opção:"); // Imprime mensagem para escolha de opção
                System.out.println("1 - Criar uma conta"); // Imprime opção para criar uma conta
                System.out.println("2 - Ver o saldo de uma conta"); // Imprime opção para ver o saldo de uma conta
                System.out.println("3 - Sacar"); // Imprime opção para sacar
                System.out.println("4 - Depositar"); // Imprime opção para depositar
                System.out.println("Qualquer outro número para finalizar"); // Imprime opção para finalizar o programa

                opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) { // Início da estrutura switch-case
                    case 1: // Caso a opção seja 1
                        criarConta(contas, scanner); // Chama o método para criar uma conta
                        break; // Sai do switch
                    case 2: // Caso a opção seja 2
                        verSaldo(contas, scanner); // Chama o método para ver o saldo de uma conta
                        break; // Sai do switch
                    case 3: // Caso a opção seja 3
                        sacar(contas, scanner); // Chama o método para sacar
                        break; // Sai do switch
                    case 4: // Caso a opção seja 4
                        depositar(contas, scanner); // Chama o método para depositar
                        break; // Sai do switch
                    default: // Caso a opção não seja 1, 2, 3 ou 4
                        System.out.println("Programa finalizado."); // Imprime mensagem de finalização do programa
                }
            } while (opcao >= 1 && opcao <= 4); // Repete o loop enquanto a opção estiver entre 1 e 4
        }

        salvarContas(contas); // Salva as contas no arquivo ao finalizar o programa
    }

    private static ArrayList<Conta> carregarContas() { // Método para carregar as contas do arquivo
        ArrayList<Conta> contas = new ArrayList<>(); // Cria uma lista para armazenar as contas

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CONTAS))) { // Início do bloco try-with-resources para ler o arquivo de contas
            String line; // Declaração da variável line para armazenar cada linha do arquivo
            while ((line = br.readLine()) != null) { // Lê cada linha do arquivo até encontrar o final do arquivo
                String[] dados = line.split(","); // Divide a linha em partes usando a vírgula como delimitador
                Conta conta = new Conta(dados[0], Integer.parseInt(dados[1]), Double.parseDouble(dados[2])); // Cria uma nova conta com os dados lidos do arquivo
                contas.add(conta); // Adiciona a conta à lista de contas
            }
        } catch (FileNotFoundException e) { // Captura a exceção caso o arquivo de contas não seja encontrado
            System.out.println("Arquivo de contas não encontrado. Criando novo arquivo..."); // Imprime mensagem de aviso
        } catch (IOException e) { // Captura a exceção caso ocorra um erro de leitura do arquivo
            System.out.println("Erro ao ler o arquivo de contas: " + e.getMessage()); // Imprime mensagem de erro
        }

        return contas; // Retorna a lista de contas
    }

    private static void salvarContas(ArrayList<Conta> contas) { // Método para salvar as contas no arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_CONTAS))) { // Início do bloco try-with-resources para escrever no arquivo de contas
            for (Conta conta : contas) { // Itera sobre todas as contas na lista de contas
                bw.write(conta.getNomeTitular() + "," + conta.getNumero() + "," + conta.getSaldo()); // Escreve os dados da conta no arquivo
                bw.newLine(); // Escreve uma quebra de linha para separar as contas
            }
        } catch (IOException e) { // Captura a exceção caso ocorra um erro ao salvar as contas no arquivo
            System.out.println("Erro ao salvar as contas: " + e.getMessage()); // Imprime mensagem de erro
        }
    }

    private static void criarConta(ArrayList<Conta> contas, Scanner scanner) { // Método para criar uma nova conta
        System.out.println("Digite o nome do titular:"); // Imprime mensagem solicitando o nome do titular
        String nomeTitular = scanner.nextLine(); // Lê o nome do titular digitado pelo usuário
        System.out.println("Digite o saldo inicial:"); // Imprime mensagem solicitando o saldo inicial
        double saldoInicial = scanner.nextDouble(); // Lê o saldo inicial digitado pelo usuário
        int numeroConta = contas.size() + 1; // Define o número da conta como o próximo disponível
        Conta novaConta = new Conta(nomeTitular, numeroConta, saldoInicial); // Cria uma nova conta com os dados fornecidos
        contas.add(novaConta); // Adiciona a nova conta à lista de contas
        System.out.println("Conta criada com sucesso. Número da conta: " + numeroConta); // Imprime mensagem de sucesso na criação da conta
    }

    private static void verSaldo(ArrayList<Conta> contas, Scanner scanner) { // Método para ver o saldo de uma conta
        System.out.println("Digite o número da conta:"); // Imprime mensagem solicitando o número da conta
        int numeroConta = scanner.nextInt(); // Lê o número da conta digitado pelo usuário
        Conta conta = encontrarConta(contas, numeroConta); // Procura a conta com o número fornecido
        if (conta != null) { // Se a conta for encontrada
            System.out.println("Saldo da conta " + numeroConta + ": " + conta.getSaldo()); // Imprime o saldo da conta
        }
    }

    private static void sacar(ArrayList<Conta> contas, Scanner scanner) { // Método para realizar um saque
        System.out.println("Digite o número da conta:"); // Imprime mensagem solicitando o número da conta
        int numeroConta = scanner.nextInt(); // Lê o número da conta digitado pelo usuário
        Conta conta = encontrarConta(contas, numeroConta); // Procura a conta com o número fornecido
        if (conta != null) { // Se a conta for encontrada
            System.out.println("Digite o valor a ser sacado:"); // Imprime mensagem solicitando o valor a ser sacado
            double valor = scanner.nextDouble(); // Lê o valor do saque digitado pelo usuário
            conta.sacar(valor); // Realiza o saque na conta
        }
    }

    private static void depositar(ArrayList<Conta> contas, Scanner scanner) { // Método para realizar um depósito
        System.out.println("Digite o número da conta:"); // Imprime mensagem solicitando o número da conta
        int numeroConta = scanner.nextInt(); // Lê o número da conta digitado pelo usuário
        Conta conta = encontrarConta(contas, numeroConta); // Procura a conta com o número fornecido
        if (conta != null) { // Se a conta for encontrada
            System.out.println("Digite o valor a ser depositado:"); // Imprime mensagem solicitando o valor a ser depositado
            double valor = scanner.nextDouble(); // Lê o valor do depósito digitado pelo usuário
            conta.depositar(valor); // Realiza o depósito na conta
        }
    }

    private static Conta encontrarConta(ArrayList<Conta> contas, int numeroConta) { // Método para encontrar uma conta pelo número
        for (Conta conta : contas) { // Percorre todas as contas na lista de contas
            if (conta != null && conta.getNumero() == numeroConta) { // Verifica se a conta não é nula e tem o número desejado
                return conta; // Retorna a conta encontrada
            }
        }
        System.out.println("Conta não encontrada."); // Imprime mensagem indicando que a conta não foi encontrada
        return null; // Retorna null indicando que a conta não foi encontrada
    }
}
