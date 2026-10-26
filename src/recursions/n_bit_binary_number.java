package recursions;

import java.util.*;

public class n_bit_binary_number {
    static void main(String[] args) {
        int n=4;
        int zc=0;
        int oc=0;
        int i=0;
        StringBuilder sb = new StringBuilder();
        List<String>res=new ArrayList<>();
        helper(i,n,zc,oc,sb,res);
        System.out.println(res);
    }
    public static void helper(int i,int n, int zc, int oc, StringBuilder sb, List<String> res){
        if(zc>oc){
            return;
        }
        if(i==n){
            res.add(sb.toString());
            return;
        }
        sb.append("1");
        helper(i+1,n,zc,oc+1,sb,res);
        sb.deleteCharAt(sb.length()-1);

        sb.append("0");
        helper(i+1,n,zc+1,oc,sb,res);
        sb.deleteCharAt(sb.length()-1);
    }
}
