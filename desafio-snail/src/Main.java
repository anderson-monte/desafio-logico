import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(10) ;

        int[][] matriz = new int[n][n];
        Arrays.setAll(matriz, i -> {
            Arrays.setAll(matriz[i], j -> random.nextInt(999));
            return matriz[i];
        });

        String matrizString = Arrays.deepToString(matriz)
                .replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]");

        System.out.println(matrizString);

        List<Integer> lista = snail(matriz);
        System.out.println("Lista pecorrida: " + lista);
    }

    public  static List<Integer> snail(int[][] matriz) {
        List<Integer> lista = new ArrayList<>();
        if (matriz.length == 0)
            return lista;

        int topo = 0;
        int base = matriz.length - 1;
        int esquerda = 0;
        int direita = matriz[0].length - 1;

        while (topo <= base && esquerda <= direita) {
            for (int i = esquerda; i <= direita; i++)
                lista.add(matriz[topo][i]);
            topo++;

            for (int i = topo; i <= base; i++)
                lista.add(matriz[i][direita]);
            direita--;

            if (topo <= base)
                for (int i = direita; i >= esquerda; i--) lista.add(matriz[base][i]);
            base--;

            if (esquerda <= direita)
                for (int i = base; i >= topo; i--) lista.add(matriz[i][esquerda]);
            esquerda++;
        }

        return lista;
    }
}