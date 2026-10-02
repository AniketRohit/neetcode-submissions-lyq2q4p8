class Solution {
    public int maxProduct(int[] nums) {
        return maxProduct1(nums);
    }


    public static int maxProduct1(int[] nums) {
        int l = nums.length;
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int max = nums[0];
        for(int i=1;i<l;i++){
            int curr = nums[i];

            int tempMax = Math.max(curr,Math.max(maxEnding*curr,minEnding*curr));
            int tempMin = Math.min(curr,Math.min(maxEnding*curr,minEnding*curr));

            maxEnding = tempMax;
            minEnding = tempMin;

            max = Math.max(max,maxEnding);
        }

        return max;
    }
}
