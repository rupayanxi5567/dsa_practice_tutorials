package recursions;

public class find_min_elem {
    public static int helper( int[] a,int n,int min){
        if(n<0){
            return min;
        }
        min=Math.min(min,a[n]);
        return helper(a,n-1,min);
    }

    static void main() {
        int []a={11,2,80,4,5};
        int n=a.length;
        int min=Integer.MAX_VALUE;
        System.out.println(helper(a,n-1,min));
    }
}
