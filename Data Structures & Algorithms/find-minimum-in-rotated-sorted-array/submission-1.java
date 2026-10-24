
class Solution {
    public int findMin(int[] nums) {

        int st = 0;
        int end = nums.length - 1;

        while (st < end) {

            int mid = st + (end - st) / 2;

            // If the current range is sorted
            if (nums[st] < nums[end]) {
                return nums[st];
            }

            if (nums[mid] > nums[end]) {
                // Minimum is to the right of mid
                st = mid + 1;
            } else {
                // Minimum is at mid or to its left
                end = mid;
            }
        }

        return nums[st];
    }
}
