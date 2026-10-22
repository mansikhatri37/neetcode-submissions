class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        
        int st = 0 ; 
        int end = n * m - 1;

        while(st <= end){

            int mid = st + (end-st)/2;

            int midEl = matrix[mid/n][mid%n];

            if(midEl == target){
                return true;
            }
            if(midEl < target){
                
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return false;
    }
}
