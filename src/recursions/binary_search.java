package recursions;

public class binary_search {
    public static int helper(int [] a,int x,int l,int r){
        if(l>r){
            return -1;
        }

        int m = l+(r-l)/2;

        if(x==a[m]){
            return m;
        }else if(x>a[m]){
            return helper(a,x,m+1,r);
        }
        return helper(a,x,l,m-1);
    }

    static void main() {
        int []a={1,2,3,4,5};
        int x=13;
        int l=0;
        int r=a.length-1;
        System.out.printf("Element %d is present at index: %d",x,helper(a,x,l,r));
    }
}
