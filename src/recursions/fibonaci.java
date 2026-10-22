package recursions;

public class fibonaci {

    public static int helper(int n){
        if(n<=1){
            return n;
        }
        return helper(n-1)+helper(n-2);
    }

    static void main() {
        System.out.println(helper(10));
    }
}
