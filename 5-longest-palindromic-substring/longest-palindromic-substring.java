class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i < s.length();i++){
             String odd = expand(s,i,i);
             if(ans.length() < odd.length()){
                 ans = odd;
             }
             if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                 String even = expand(s,i,i+1);
                 if(ans.length() < even.length()){
                     ans = even;
                 }
             }
        }
        return ans;
    }
    String expand(String s,int p1,int p2){
        while(p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
              p1--;
              p2++;
        }
        return s.substring(p1+1,p2);
    }
}