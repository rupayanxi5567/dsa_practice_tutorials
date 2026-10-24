package recursions;

import java.util.ArrayList;
import java.util.List;

public class target_sum_repetition {
    public static void helper(int[] a, int i, int n, List<Integer> al, List<List<Integer>> res, int x, int sum) {
        if (sum == x) {
            res.add(new ArrayList<>(al));
            return;
        }
        if (i == n || sum > x) {
            return;
        }

        al.add(a[i]);
        helper(a, i, n, al, res, x, sum + a[i]);
        al.remove(al.size() - 1);

        helper(a, i + 1, n, al, res, x, sum);
    }

    static void main(String[] args) {
        int x=8;
        int sum=0;
        int []a={2,5,6,1};
        int i=0;
        int n=a.length;
        List<Integer>al=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        helper(a,i,n,al,res,x,sum);

        System.out.println(res);
        System.out.println(res.size());
    }
}
