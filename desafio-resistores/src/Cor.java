import java.util.Arrays;
import java.util.stream.Stream;

public enum Cor {
    PRETO(0),
    MARROM(1),
    VERMELHO(2),
    LARANJA(3),
    AMARELO(4),
    VERDE(5),
    AZUL(6),
    VIOLETA(7),
    CINZA(8),
    BRANCO(9);

    private final int valor;

    Cor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static String getCorPorValor(int valor) {
        return Stream.of(Cor.values())
                .filter(cor -> cor.getValor() == valor)
                .findFirst()
                .map(Enum::toString)
                .map(String::toLowerCase)
                .orElseThrow(() -> new IllegalArgumentException("Valor inválido: " + valor));
    }
}
