class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> dq = new ArrayDeque<>();

        int [] res = new int[nums.length - k + 1];

        for(int r = 0 ; r < nums.length ; r++){

            //remove indices outside of the current window size
            if(!dq.isEmpty() && dq.peekFirst() <= r - k){
                dq.pollFirst();
            }

            //remove the elements from last that are smaller than the current value
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]){
                dq.pollLast();
            }

            //add the current index
            dq.offerLast(r);

            //add the maximum in the res
            if(r >= k - 1){
                 res[r - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
