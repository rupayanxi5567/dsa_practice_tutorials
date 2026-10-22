package recursions;

public class power_of_2 {
    public static int helper(int x){
        if(x==1){
            return 2;
        }
        return 2*helper(x-1);
    }
    static void main(String[] args) {
        int pow=6;
        System.out.println(helper(pow));
    }
}
