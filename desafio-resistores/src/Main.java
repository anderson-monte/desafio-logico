import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do resistor:");
        String resistorInput = scanner.nextLine();
        scanner.close();

        String[] split = resistorInput.split(" ");
        var valorResistor = split[0];

        int valor;
        if (valorResistor.contains("k")) {
            valor = Integer.parseInt(valorResistor.replace("k", "")) * 1000;
        } else if (valorResistor.contains("M")) {
            valor = Integer.parseInt(valorResistor.replace("M", "")) * 1000000;
        } else {
            valor = Integer.parseInt(valorResistor);
        }

        var valorStr = String.valueOf(valor);
        int primeiroDigito = Integer.parseInt(valorStr.substring(0, 1));
        int segundoDigito = Integer.parseInt(valorStr.substring(1, 2));
        int multiplicador = valorStr.length() - 2;

        String colorCode = Cor.getCorPorValor(primeiroDigito) + " " +
                Cor.getCorPorValor(segundoDigito) + " " +
                Cor.getCorPorValor(multiplicador) + " " +
                "dourado";

        System.out.println(resistorInput + " => " + colorCode);
    }
}