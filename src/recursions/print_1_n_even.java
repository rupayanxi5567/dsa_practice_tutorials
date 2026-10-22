package recursions;

public class print_1_n_even {
    public static void helper(int n){
        if(n==2){
            System.out.println(n);
            return;
        }
        helper(n-1);
        if(n%2==0){
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        helper(50);
    }
}
