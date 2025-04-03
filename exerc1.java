public class exerc1 {

    public static void main(String[] args) {
        int[] valoresTeste = {4, 8, 16, 32, 128, 1000, 10000};

        System.out.println("Testando FiboRec (somente até 32 para evitar demora)");
        for (int n : valoresTeste) {
            if (n > 32) break; // FiboRec é muito lento para valores grandes
            System.out.println("FiboRec(" + n + ") = " + FiboRec(n));
        }

        System.out.println("\nTestando Fibo");
        for (int n : valoresTeste) {
            System.out.println("Fibo(" + n + ") = " + Fibo(n));
        }

        System.out.println("\nTestando MemoizedFibo");
        for (int n : valoresTeste) {
            int[] f = new int[n + 1]; // Criando o array para memoization
            System.out.println("MemoizedFibo(" + n + ") = " + MemoizedFibo(f, n));
        }
    }

    public static int FiboRec(int n) {
        if (n <= 1) {
            return n;
        }
        return FiboRec(n - 1) + FiboRec(n - 2);
    }

    public static int Fibo(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static int MemoizedFibo(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return LookupFibo(f, n);
    }

    public static int LookupFibo(int[] f, int n) {
        if (f[n] >= 0) return f[n];

        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = LookupFibo(f, n - 1) + LookupFibo(f, n - 2);
        }
        return f[n];
    }
}
