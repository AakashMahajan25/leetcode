class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Optimal Approach (BS) TC->O(log(min(m,n))) SC->O(1)
        int m = nums1.length;
        int n = nums2.length;
        if (m>n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int t = m + n;
        int left = (m+n+1)/2;
        int low = 0;
        int high = m;
        while (low<=high) {
            int mid1 = low + (high-low)/2;
            int mid2 = left-mid1;
            int l1 = mid1>0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2>0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1<m ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2<n ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1>r2) high = mid1-1;
            if (l2>r1) low = mid1+1;
            if (l1<=r2 && l2<=r1) {
                if ((m+n)%2==1) {
                    return (double) Math.max(l1, l2);
                } else {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
            }
        }
        return 0;


        // Normal Approach TC->O(m+n) SC->O(1)
        // int m = nums1.length;
        // int n = nums2.length;
        // int i = 0;
        // int j = 0;
        // int currentIndex = 0;
        // int mid2 = (m+n)/2;
        // int mid1 = mid2-1;
        // int mid2Element = -1;
        // int mid1Element = -1;
        // while ((i<m) && (j<n)) {
        //     if (nums1[i] < nums2[j]) {
        //         if (currentIndex==mid1) mid1Element = nums1[i];
        //         if (currentIndex==mid2) mid2Element = nums1[i];
        //         currentIndex++;
        //         i++;
        //     } else {
        //         if (currentIndex==mid1) mid1Element = nums2[j];
        //         if (currentIndex==mid2) mid2Element = nums2[j];
        //         currentIndex++;
        //         j++;
        //     }
        // }
        // while (i<m) {
        //     if (currentIndex==mid1) mid1Element = nums1[i];
        //     if (currentIndex==mid2) mid2Element = nums1[i];
        //     currentIndex++;
        //     i++;
        // }
        // while (j<n) {
        //     if (currentIndex==mid1) mid1Element = nums2[j];
        //     if (currentIndex==mid2) mid2Element = nums2[j];
        //     currentIndex++;
        //     j++;
        // }

        // if ((m+n)%2==0) return (double)(mid1Element+mid2Element)/2;
        // return mid2Element;
    }
}