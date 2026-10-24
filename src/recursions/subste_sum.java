package recursions;

import java.util.ArrayList;
import java.util.List;

public class subste_sum {

    public static void helper(int [] a,int i,int n,List<Integer>res,int sum){
        if(i==n){
            res.add(sum);
            return;
        }
        sum+=a[i];
        helper(a,i+1,n,res,sum);
        sum-=a[i];
        helper(a,i+1,n,res,sum);
    }

    static void main(String[] args) {
        int sum=0;
        int []a={3,4,5};
        int i=0;
        int n=a.length;
        List<Integer>res=new ArrayList<>();
        helper(a,i,n,res,sum);

        System.out.println(res);
        System.out.println(res.size());
    }
}
