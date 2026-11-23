
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0;
        int p2 = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        int combinedLen = len1 + len2;

        int[] combinedArray = new int[combinedLen];

        int i = 0;

        // Compare elements while both arrays have elements
        while (p1 < len1 && p2 < len2) {

            if (nums1[p1] < nums2[p2]) {
                combinedArray[i] = nums1[p1];
                p1++;
            }
            else {
                combinedArray[i] = nums2[p2];
                p2++;
            }

            i++;
        }

        // Copy remaining elements from nums1
        while (p1 < len1) {
            combinedArray[i] = nums1[p1];
            p1++;
            i++;
        }

        // Copy remaining elements from nums2
        while (p2 < len2) {
            combinedArray[i] = nums2[p2];
            p2++;
            i++;
        }

        // Find median
        if (combinedLen % 2 != 0) {
            return combinedArray[combinedLen / 2];
        }
        else {
            int mid1 = combinedArray[combinedLen / 2];
            int mid2 = combinedArray[(combinedLen / 2) - 1];

            return (mid1 + mid2) / 2.0;
        }
    }
}
