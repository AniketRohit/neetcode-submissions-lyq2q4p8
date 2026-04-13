class Solution {
    public int maxSubArray(int[] arr) {
        int ans = arr[0];
        int l = arr.length;
        int sum = arr[0];
        for(int i = 1;i<l;i++){
            sum = Math.max(arr[i],sum+arr[i]);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
