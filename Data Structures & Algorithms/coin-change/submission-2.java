class Solution {
    private int recursion(int[] coins, int amount){
        if(amount == 0)return 0;
        int count = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount-coin >=0){
                count = Math.min(count, 1+recursion(coins,amount-coin));
            }
        }
        return count;
    }

    private int dpFun(int[] coins, int amount, Map<Integer, Integer> map){
        if(amount == 0)return 0;
        if(map.containsKey(amount))return map.get(amount);
        int count = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount-coin >=0){
               int result = dpFun(coins, amount-coin, map);
               if(result != Integer.MAX_VALUE){
                count = Math.min(count, 1+result);
               }
            }
        }
        map.put(amount,count);
        return count;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = dpFun(coins, amount, map);
        if(ans == Integer.MAX_VALUE)return -1;
        else return ans;
    }
}
