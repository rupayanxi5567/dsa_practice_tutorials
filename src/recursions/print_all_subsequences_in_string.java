package recursions;

import java.util.ArrayList;
import java.util.List;

public class print_all_subsequences_in_string {
    public static void helper(String s,StringBuilder sb, List<String>res, int i, int n){
        if(i==n){
            res.add(sb.toString());
            return;
        }

        sb.append(s.charAt(i));
        helper(s,sb,res,i+1,n);

        sb.deleteCharAt(sb.length()-1);
        helper(s,sb,res,i+1,n);
    }

    static void main(String[] args) {
        int i=0;
        String s = "Anushka";
        StringBuilder sb = new StringBuilder();
        int n=s.length();
        List<String>res=new ArrayList<>();
        helper(s,sb,res,i,n);

        System.out.println(res);
        System.out.println(res.size());
    }
}
