package recursions;

public class factorial {

    public static int helper(int n){
        if(n<=1){
            return 1;
        }
        return n*helper(n-1);
    }

    static void main(String[] args) {
        System.out.println((helper(8)));
    }
}
