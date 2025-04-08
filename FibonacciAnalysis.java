import java.util.HashMap;

public class FibonacciAnalysis {
    public static void main(String[] args) {
        int[] valoresTeste = {4, 8, 16, 32, 128, 1000, 10000};

        System.out.printf("%-20s %-10s %-15s %-20s\n", "Algoritmo", "n", "Tempo (ms)", "Iterações/Chamadas");
        System.out.println("------------------------------------------------------------------");

        for (int n : valoresTeste) {
            if (n <= 32) {
                FiboRec.counter = 0;
                long start = System.nanoTime();
                int result = FiboRec.fiboRec(n);
                long end = System.nanoTime();
                System.out.printf("%-20s %-10d %-15.5f %-20d\n", "FiboRec", n, (end - start) / 1e6, FiboRec.counter);
            }
        }

        for (int n : valoresTeste) {
            long start = System.nanoTime();
            int iterations = Fibo.countIterations(n);
            int result = Fibo.fibo(n);
            long end = System.nanoTime();
            System.out.printf("%-20s %-10d %-15.5f %-20d\n", "Fibo", n, (end - start) / 1e6, iterations);
        }

        for (int n : valoresTeste) {
            long start = System.nanoTime();
            int iterations = MemoizedFibo.countIterations(n);
            int[] f = new int[n + 1];
            int result = MemoizedFibo.memoizedFibo(f, n);
            long end = System.nanoTime();
            System.out.printf("%-20s %-10d %-15.5f %-20d\n", "MemoizedFibo", n, (end - start) / 1e6, iterations);
        }
    }
}

class FiboRec {
    static int counter = 0;
    public static int fiboRec(int n) {
        counter++;
        if (n <= 1) {
            return n;
        }
        return fiboRec(n - 1) + fiboRec(n - 2);
    }
}

class Fibo {
    public static int fibo(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    
    public static int countIterations(int n) {
        return n - 1; // O loop roda (n - 1) vezes
    }
}

class MemoizedFibo {
    public static int memoizedFibo(int[] f, int n) {
        for (int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }
    
    private static int lookupFibo(int[] f, int n) {
        if (f[n] >= 0) return f[n];
        if (n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        return f[n];
    }
    
    public static int countIterations(int n) {
        return n; // Aproximadamente n chamadas devido ao memoization
    }
}
