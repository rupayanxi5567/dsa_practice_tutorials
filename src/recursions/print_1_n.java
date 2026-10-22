package recursions;

public class print_1_n {

    public static void helper(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        helper(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        helper(5);
    }
}
