package recursions;

import java.util.*;

public class permutation_of_array_repited {
    public static void main() {
        int []a={1,1,2};
        int i=0;
        int n=a.length;
        List<List<Integer>>res=new ArrayList<>();
        helper(a,i,n,res);
        System.out.println(res);
        System.out.println(res.size());
    }
    public static void helper(int[] a, int i, int n, List<List<Integer>> res){

        if(i==n){
            List<Integer>al=new ArrayList<>();
            for(int x:a){
                al.add(x);
            }
            res.add(new ArrayList<>(al));
            return;
        }
        int []vis=new int[21];
        for (int k=i;k<n;k++){
            if(vis[a[k]]==1){
                continue;
            }
            vis[a[k]]=1;
            swaps(a,k,i);
            helper(a,i+1,n,res);
            swaps(a,k,i);
        }
    }

    private static void swaps(int[] a, int x, int y) {
        int tep=a[x];
        a[x]=a[y];
        a[y]=tep;
    }
}


