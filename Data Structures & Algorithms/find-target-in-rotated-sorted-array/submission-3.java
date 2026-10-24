class Solution {
    public int search(int[] nums, int target) {
        
        int st = 0;
        int end = nums.length - 1;

        while(st <= end){

            int mid = st + (end - st) / 2;

            if(nums[mid] == target){
                return mid;
            }

            //if the left part is sorted
            if(nums[st] <= nums[mid]){

                //check if the target lies in the left sorted part
                if(nums[st] <= target && target < nums[mid]){
                    end = mid - 1; //search in the left part
                }
                else{
                    //search in the right part
                    st = mid + 1;
                }
            }
            else{

                //if the right part is sorted
                if(nums[mid] < target  && target <= nums[end]){
                    st = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return -1; //target not found
    }
}
