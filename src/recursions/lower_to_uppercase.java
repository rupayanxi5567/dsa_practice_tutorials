package recursions;

import java.util.Locale;

public class lower_to_uppercase {
    public static void helper(char[]a,int i,int n){
        if(n==i){
            return;
        }

        a[i] = Character.toUpperCase(a[i]);
        helper(a,i+1,n);

    }

    static void main(String[] args) {
        String s = "anushka";
        int i=0;
        int n = s.length();
        char[]a=s.toCharArray();
        helper(a,i,n);
        a.toString();
        System.out.println(new String(a));
    }
}
