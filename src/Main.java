import br.com.alura.challange.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1) Dólar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dólar");
            System.out.println("3) Dólar => Real Brasileiro");
            System.out.println("4) Real Brasileiro => Dólar");
            System.out.println("5) Dólar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dólar");
            System.out.println("7) Sair");

            int choice = scanner.nextInt();
            if (choice < 7) {
                System.out.println("Digite o valor a ser convertido:");
                double amount = scanner.nextDouble();

                String result = converter.convert(choice, amount);
                System.out.println("Resultado: " + result);
            }

            if (choice > 7) {
                System.out.println("Opção invalida");
            };

            if (choice == 7) break;
        }

        scanner.close();
    }
}
