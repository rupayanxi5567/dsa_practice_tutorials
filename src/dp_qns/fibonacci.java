package dp_qns;

public class fibonacci {
    public static void main(String[] args) {
        int n = 80;
        long[] fib = new long[n + 1];
        System.out.println(helper(n, fib));
    }

    public static long helper(int n, long[] fib) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = helper(n - 1, fib) + helper(n - 2, fib);
        return fib[n];
    }
}