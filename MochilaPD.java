public class MochilaPD {
    static int iteracoes = 0;

    public static void main(String[] args) {
        int capacidade = 5;
        int[][] itens = {
            {0, 0},
            {2, 3},
            {3, 4},
            {4, 5},
            {5, 6}
        };
        int N = itens.length - 1;

        int resultado = backPackPD(N, capacidade, itens);
        System.out.println("Melhor valor com PD: " + resultado);
        System.out.println("Número de iterações: " + iteracoes);
    }

    public static int backPackPD(int N, int C, int[][] itens) {
        int[][] maxTab = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoes++;
                int peso = itens[i][0];
                int valor = itens[i][1];

                if (peso <= j) {
                    maxTab[i][j] = Math.max(maxTab[i - 1][j], valor + maxTab[i - 1][j - peso]);
                } else {
                    maxTab[i][j] = maxTab[i - 1][j];
                }
            }
        }

        return maxTab[N][C];
    }
}
