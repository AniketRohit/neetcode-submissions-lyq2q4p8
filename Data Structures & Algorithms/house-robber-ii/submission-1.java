class Solution {

    private int dpFun(int[] nums, int start, int end){
        int len = end - start + 1;
        if (len == 1) {
            return nums[start];
        }
        int[] dp = new int[len + 1];
        dp[1] = nums[start];
        dp[2] = Math.max(nums[start], nums[start + 1]);

        for (int i = 3; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[start + i - 1]);
        }
        return dp[len];
    }

    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1)return nums[0];
        
        return Math.max(dpFun(nums,0,l-2), dpFun(nums,1,l-1));
    }
}
