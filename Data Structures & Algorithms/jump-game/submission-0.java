class Solution {

    public static boolean canJump(int[] arr) {
        int l = arr.length;
        int maxReach = 0;
        for(int i=0;i<l;i++){
            if(i>maxReach)return false;
            maxReach = Math.max(maxReach,i+arr[i]);
            if(maxReach >= l-1)return true;
        }
        return true;
    }
}
