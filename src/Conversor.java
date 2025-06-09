
import java.util.Scanner;

public class Conversor {
    private final Scanner scanner;
    private final ExchangeRate api;

    public Conversor(Scanner scanner) {
        this.scanner = scanner;
        this.api = new ExchangeRate();
    }

    public void executar() {
        while (true) {
            System.out.println("\n********** Conversor de Moedas ************");
            System.out.println("1 - Dólar para Real");
            System.out.println("2 - Euro para Real");
            System.out.println("3 - Real para Dólar");
            System.out.println("4 - Real para Euro");
            System.out.println("5 - Peso Mexicano para Real");
            System.out.println("6 - Real para Peso Mexicano");
            System.out.println("7 - Won para Real");
            System.out.println("8 - Real para Won");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            if (opcao == 0) break;

            String from = "", to = "";

            switch (opcao) {
                case 1 -> { from = "USD"; to = "BRL"; }
                case 2 -> { from = "EUR"; to = "BRL"; }
                case 3 -> { from = "BRL"; to = "USD"; }
                case 4 -> { from = "BRL"; to = "EUR"; }
                case 5 -> { from = "MXN"; to = "BRL"; }
                case 6 -> { from = "BRL"; to = "MXN"; }
                case 7 -> { from = "KRW"; to = "BRL"; }
                case 8 -> { from = "BRL"; to = "KRW"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            System.out.print("Digite o valor para conversão: ");
            double valor = scanner.nextDouble();

            double taxa = api.obterCambio(from, to);
            if (taxa == -1) {
                System.out.println("Erro ao obter taxa de câmbio.");
                continue;
            }

            double convertido = valor * taxa;
            System.out.printf("Resultado: %.2f %s = %.2f %s\n", valor, from, convertido, to);
        }

        System.out.println("Programa encerrado.");
    }
}