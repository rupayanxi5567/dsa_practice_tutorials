package recursions;

public class print_array {

    public static void helper( int[] a,int n){
        if(n==0){
            System.out.println(a[n]);
            return;
        }
        System.out.println(a[n]);
        helper(a,n-1);
    }

    static void main() {
        int []a={1,2,3,4,5};
        int n=a.length;
        helper(a,n-1);
    }
}
