class Solution {
    public int countSubstrings(String s) {
        return longestPalindrome(s);
    }

    private int maxPalindromeLen(String s, int left, int right){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

    public int longestPalindrome(String s) {
        int l = s.length();

        int count1 = 0, count2 = 0;

        for(int i=0;i<l;i++){
            count1 = count1+maxPalindromeLen(s,i,i);//odd len case
            count2 = count2+maxPalindromeLen(s,i,i+1);//even len case
        }
        return count1+count2;
    }
}
