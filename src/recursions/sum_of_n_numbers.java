package recursions;

public class sum_of_n_numbers {
    static void main(String[] args) {
        int n=101;
        System.out.println(helperd(n));
    }

    private static int helperd(int n) {
        if(n<=1){
            return n;
        }
        return n+helperd(n-1);
    }
}
