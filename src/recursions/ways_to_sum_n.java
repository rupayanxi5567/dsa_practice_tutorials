package recursions;

public class ways_to_sum_n {
    static int counter=0;
    static void main() {
        int []a={1,5,6};
        int x = 7;
        int i=0;
        int sum=0;
        int n=a.length;
        helper(a,x,i,n,sum);
        System.out.println(counter);
    }
    public static void helper(int[] a, int x, int i, int n, int sum ){
        if(sum==x){
            counter++;
            return;
        }
        if(sum>x){
            return;
        }
        for(int k=i;k<n;k++){
            sum=sum+a[k];
            helper(a,x,k,n,sum);
            sum=sum-a[k];
        }
    }
}
