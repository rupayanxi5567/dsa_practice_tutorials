package recursions;

import java.util.ArrayList;
import java.util.List;

public class generate_parenthesis {
    public static void helper(int lc,int rc,int n,List<String>res,StringBuilder sb){
        if(lc==n && rc==n){
            res.add(sb.toString());
            return;
        }

        if(lc<n){
            sb.append("(");
            helper(lc+1,rc,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(lc>rc){
            sb.append(")");
            helper(lc,rc+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    static void main(String[] args) {
        int n=2;
        int lc=0;
        int rc=0;
        StringBuilder sb = new StringBuilder();
        List<String>res=new ArrayList<>();
        helper(lc,rc,n,res,sb);
        System.out.println(res);
    }
}
