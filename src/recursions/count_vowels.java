package recursions;

public class count_vowels {

    public static int helper(String s,int i,int n,int counter){
        if(i==n){
            return counter;
        }
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
            return helper(s,i+1,n,counter+1);
        }
        return helper(s,i+1,n,counter);
    }

    static void main(String[] args) {
        String s = "okay bro";
        int counter = 0;
        int i=0;
        int n = s.length();
        System.out.println(helper(s,i,n,counter));
    }
}
