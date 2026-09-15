class Solution {
    public int recursion(int[] cost, int startIdx, int totalCost){
        if(startIdx > cost.length-1)return totalCost;
        return Math.min(recursion(cost,startIdx+1,totalCost+cost[startIdx]),
        recursion(cost,startIdx+2,totalCost+cost[startIdx]));
    }

    public int dp(int[] cost, int[] minCostArr){
        for(int i=2;i<=cost.length;i++){
            minCostArr[i] = Math.min(minCostArr[i-1]+cost[i-1] ,
            minCostArr[i-2]+cost[i-2]);
        }
        return minCostArr[cost.length];
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length+1];
        arr[0] = 0;
        arr[1] = 0;
        return dp(cost, arr);
        //return Math.min(recursion(cost,0,0),recursion(cost,1,0));
    }
}
