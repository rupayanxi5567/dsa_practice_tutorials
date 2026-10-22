package recursions;

public class reverse_a_string {
    public static String helper(String s,int n){
        if(n<0){
            return "";
        }

        return s.charAt(n)+helper(s,n-1);

    }

    static void main(String[] args) {
        String s = "ayan";
        int n = s.length();
        System.out.println(helper(s,n-1));
    }
}
