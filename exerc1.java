public class exerc1 {

    public static void main(String[]args){
        
    }


    public int FiboRec(int n){
        int a=0;
        int b=0;
        if(n<=1){
            return n;
        }
        else{
            a = FiboRec(n-1);
            b = FiboRec(n-2);
            return a + b;
        }
    }

    public int Fibo(int n){
        int f[] = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public int MemoizedFibo(int[] f, int n){
        for(int i = 0; i<=n; i++){
            f[i] = -1;
        }
        return LookupFibo(f, n);
    }

    public int LookupFibo(int[] f, int n){
        if(f[n]>=0)
        return f[n];

        if(n<=1){
            f[n] = n;
        }
        else{
            f[n] = LookupFibo(f, n-1) + LookupFibo(f, n-2);
        }
        return f[n];
    }


}