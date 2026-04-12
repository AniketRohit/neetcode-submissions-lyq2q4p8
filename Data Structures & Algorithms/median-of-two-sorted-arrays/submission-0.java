class Solution {
    //O(log(min(m,n)))
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {

        if(arr1.length>arr2.length) return findMedianSortedArrays(arr2,arr1);
        int l1 = arr1.length, l2 = arr2.length;
        int low = 0, high = l1;
        while(low <= high){
            int cut1 = (low+high)/2;
            int cut2 = (l1+l2+1)/2-cut1;

            int leftMin = (cut1 == 0)?Integer.MIN_VALUE:arr1[cut1-1];
            int leftMax = (cut2 == 0)?Integer.MIN_VALUE:arr2[cut2-1];

            int rightMin = (cut1 == l1)?Integer.MAX_VALUE:arr1[cut1];
            int rightMax = (cut2 == l2)?Integer.MAX_VALUE:arr2[cut2];

            if(leftMin<=rightMax && leftMax<=rightMin){
                if((l1+l2)%2==0){
                    return (Math.max(leftMax,leftMin)+Math.min(rightMax,rightMin))/2.0;
                }else{
                    return Math.max(leftMax,leftMin);
                }
            }else if(leftMin > leftMax){
                high=cut1-1;
            }else{
                low = cut1+1;
            }
        }
        return 0.0;
    }

        //O(m+n)log(m+n)
    public double findMedianSortedArraysByHeap(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:arr1){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size()<minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        for(int num:arr2){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size()<minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }
        if(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            if((arr1.length +arr2.length)%2==0) return ((double)minHeap.peek()+(double)maxHeap.peek())/2;
            return (double)maxHeap.peek();
        }
        return 0.0;
    }
}
