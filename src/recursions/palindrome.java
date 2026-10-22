package recursions;

public class palindrome{

    public static boolean helper(int l,int r,String s){
        if(l>r){
            return false;
        }

        if(s.charAt(l)!=s.charAt(r)){
            return false;
        }

        return true;
    }

    static void main() {
        String s="maams";
        int l=0;
        int r=s.length()-1;
        System.out.println(helper(l,r,s) ? "Yes" : "No");
    }
}
