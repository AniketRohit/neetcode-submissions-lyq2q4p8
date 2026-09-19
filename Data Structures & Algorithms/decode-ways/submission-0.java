class Solution {

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(),1);
        //return dfs(s, 0, dp);
        return dpFun(0,s,dp);
    }

    public int dpFun(int i, String s, Map<Integer, Integer> map){

        if(map.containsKey(i))return map.get(i);
        if(s.charAt(i)=='0')return 0;

        int totalMsg = dpFun(i+1,s,map);
        if(i+1 < s.length()){
            if(s.charAt(i) == '1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                totalMsg += dpFun(i+2, s, map);
            }
        }
        map.put(i,totalMsg);
        return totalMsg;
    }


    private int dfs(String s, int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }

        int res = dfs(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' ||
           s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }

    public int recursion(int i, String s){
        int l = s.length();
        if(i==l)return 1;
        if(s.charAt(i)=='0')return 0;

        int totalMsg = recursion(i+1,s);
        if(i < l-1){
            if(s.charAt(i) == '1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                totalMsg += recursion(i+2, s);
            }
        }
        return totalMsg;
    }
}
