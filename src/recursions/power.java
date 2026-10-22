package recursions;

public class power {
    public static int helper(int n,int x){
        if(x==1){
            return n;
        }
        return n*helper(n,x-1);
    }
    static void main(String[] args) {
        int num=3;
        int pow=4;
        System.out.println(helper(num,pow));
    }
}
