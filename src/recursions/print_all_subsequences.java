package recursions;

import java.util.*;

public class print_all_subsequences {

    public static void helper(int []a,List<Integer>al,List<List<Integer>>res,int i,int n){
        if(i==n){
            res.add(new ArrayList<>(al));
            return;
        }
        al.add(a[i]);
        helper(a,al,res,i+1,n);
        al.removeLast();
        helper(a,al,res,i+1,n);
    }

    static void main(String[] args) {
        int i=0;
        int []a={1,2,3};
        int n=a.length;
        List<Integer>al=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        helper(a,al,res,i,n);
        System.out.println(res);
        System.out.println(res.size());
    }
}
