public class MochilaForcaBruta {
        static int iteracoes = 0;
    
        public static void main(String[] args) {
            int[] pesos = {2, 3, 4, 5};
            int[] valores = {3, 4, 5, 6};
            int capacidade = 5;
    
            Resultado resultado = mochilaBruta(pesos, valores, capacidade);
    
            System.out.println("Melhor valor: " + resultado.valorMaximo);
            System.out.println("Combinação: " + resultado.combinacaoUsada);
            System.out.println("Total de combinações testadas: " + iteracoes);
        }
    
        public static Resultado mochilaBruta(int[] pesos, int[] valores, int capacidade) {
            int n = pesos.length;
            int maxValor = 0;
            String melhorComb = "";
    
            int totalCombinacoes = 1 << n; // 2^n
    
            for (int i = 0; i < totalCombinacoes; i++) {
                iteracoes++;
                int pesoTotal = 0;
                int valorTotal = 0;
                StringBuilder combinacao = new StringBuilder();
    
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        pesoTotal += pesos[j];
                        valorTotal += valores[j];
                        combinacao.append("1");
                    } else {
                        combinacao.append("0");
                    }
                }
    
                if (pesoTotal <= capacidade && valorTotal > maxValor) {
                    maxValor = valorTotal;
                    melhorComb = combinacao.toString();
                }
            }
    
            return new Resultado(maxValor, melhorComb);
        }
    
        static class Resultado {
            int valorMaximo;
            String combinacaoUsada;
    
            Resultado(int valor, String combinacao) {
                this.valorMaximo = valor;
                this.combinacaoUsada = combinacao;
            }
        }
}
    