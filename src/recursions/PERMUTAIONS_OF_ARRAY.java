package recursions;

import java.util.*;

public class PERMUTAIONS_OF_ARRAY {
    public static void main() {
        int []a={1,2,3};
        int i=0;
        int n=a.length;
        List<Integer>al=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        boolean[]used=new boolean[n];
        helper(a,i,n,al,res,used);
        System.out.println(res);
        System.out.println(res.size());
    }
    public static void helper(int[] a, int i, int n, List<Integer> al, List<List<Integer>> res, boolean[] used){
        if(i==n){
            res.add(new ArrayList<>(al));
            return;
        }
        for (int k=0;k<n;k++){
            if(used[k]){
                continue;
            }
            used[k]=true;
            al.add(a[k]);
            helper(a,i+1,n,al,res, used);
            al.removeLast();
            used[k]=false;
        }
    }
}
