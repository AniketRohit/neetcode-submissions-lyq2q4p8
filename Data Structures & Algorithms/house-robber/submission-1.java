class Solution {

    private int dpFun(int[] arr, int[] dp){
        int n = arr.length;
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-2]+arr[i-1],dp[i-1]);
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int l = nums.length;
        if(l == 1)return nums[0];
        int[] dp = new int[l+1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        if(l ==2)return dp[2];
        return dpFun(nums,dp);
    }
}
