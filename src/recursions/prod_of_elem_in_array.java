package recursions;

public class prod_of_elem_in_array {
    public static int helper( int[] a,int n){
        if(n==0){
            return a[n];
        }
        return a[n]*helper(a,n-1);
    }

    static void main() {
        int []a={11,2,3,4,5};
        int n=a.length;
        System.out.println(helper(a,n-1));
    }
}
