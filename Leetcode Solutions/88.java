class Solution {

    public void swapIfGreater(int[] arr1, int[] arr2, int index1, int index2) {
        if (arr1[index1] > arr2[index2]) {
            int temp = arr1[index1];
            arr1[index1] = arr2[index2];
            arr2[index2] = temp;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalLength = m + n;
        int gap = (totalLength / 2) + (totalLength % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < totalLength) {
                // Case 1: both pointers in nums1
                if (left < m && right < m) {
                    swapIfGreater(nums1, nums1, left, right);
                }
                // Case 2: left in nums1, right in nums2
                else if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                }
                // Case 3: both in nums2
                else {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        // Copy nums2 into nums1 after m elements
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}
