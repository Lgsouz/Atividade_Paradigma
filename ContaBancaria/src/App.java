import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         try (Scanner scanner = new Scanner(System.in)) {
            ContaBancaria conta = null;

            System.out.println("Escolha o tipo de conta: 1-Corrente ou 2-Poupança");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    conta = new ContaCorrente();
                    break;
                case 2:
                    conta = new ContaPoupança();
                    break;
                default:
                    System.out.println("Tipo de conta inválido!");
                    System.exit(0);
            }

            while (true) {
                System.out.println("\nEscolha uma ação: Depositar 1, Sacar 2, Exibir Saldo 3, Sair 4");
                int acao = scanner.nextInt();

                switch (acao) {
                    case 1:
                        System.out.println("Digite o valor a depositar:");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Digite o valor a sacar:");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Saldo atual: R$" + conta.obterSaldo());
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ação inválida!");
                }
            }
        }
    }
}
