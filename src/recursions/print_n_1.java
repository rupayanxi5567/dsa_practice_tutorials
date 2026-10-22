package recursions;

public class print_n_1 {
    public static void helper(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        helper(n-1);
    }

    public static void main(String[] args) {
        helper(5);
    }
}
