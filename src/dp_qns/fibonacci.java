package dp_qns;

public class fibonacci {
    static void main() {
        int n=50;
        int[] fib = new int[n+1];
        fib[0]=0;
        fib[1]=1;
        System.out.println(helper(n,fib));
    }
    public static int helper(int n,int[] fib){
        if(n==0 || n==1){
            return n;
        }
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n]=helper(n-1,fib)+helper(n-2,fib);
        return fib[n];
    }
}
