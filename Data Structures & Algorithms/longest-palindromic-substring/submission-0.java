class Solution {

    private int maxPalindromeLen(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public String longestPalindrome(String s) {
        int l = s.length();
        if(l<2)return s;

        int start = 0, end = 0;

        for(int i=0;i<l;i++){
            int len1 = maxPalindromeLen(s,i,i);//odd len case
            int len2 = maxPalindromeLen(s,i,i+1);//even len case

            int len = Math.max(len1,len2);

            if(len > end-start+1){
                start = i- (len - 1)/2; //as i our centre of thr palindrome
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }
}
