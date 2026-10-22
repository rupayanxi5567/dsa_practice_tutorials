package recursions;

public class linear_search {

    public static int helper(int [] a,int x,int i,int n){
        if(i==n){
            return -1;
        }
        if(x==a[i]){
            return i;
        }
        return helper(a,x,i+1,n);
    }

    static void main() {
        int []a={1,2,3,4,5};
        int x=3;
        int i=0;
        int n=a.length;
        System.out.printf("Element %d is present at index: %d",x,helper(a,x,i,n));
    }
}
