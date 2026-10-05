/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)->a.start-b.start);

        for (int i = 1; i < intervals.size(); i++) {
            Interval i1 = intervals.get(i - 1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.start) {
                return false;
            }
        }

        return true;
    }


    // private static boolean canAttend(int[][] arr) {
    //     // code here
    //    Arrays.sort(arr,(a,b) -> a[0]-b[0]);
    //    for(int i=0;i<arr.length-1;i++){
    //        if(arr[i][1] > arr[i+1][0])return false;
    //    }
    //    return true;
    // }
}
