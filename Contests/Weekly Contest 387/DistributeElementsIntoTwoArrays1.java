
//CODE IS NOT WORKING / WRONG LOGIC



public class DistributeElementsIntoTwoArrays1 {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }
    public int[] resultArray(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new int[0]; 
        }

        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];

        if (nums.length >= 1) {
            arr1[0] = nums[0];
        }
        
        if (nums.length >= 2) {
            arr2[0] = nums[1];
        }

        int indexArr1 = 1, indexArr2 = 1;
        
        if (nums.length >= 3) {
            for (int i = 2; i < nums.length; i++) {
                if (arr1[indexArr1] > arr2[indexArr2]) {
                    arr2[indexArr2] = nums[i];
                    indexArr2++;
                } else {
                    arr1[indexArr1] = nums[i];
                    indexArr1++;
                }
            }
        }

        int[] result = new int[indexArr1 + indexArr2];

        reverseArray(arr2);

        System.arraycopy(arr1, 0, result, 0, indexArr1);
        for (int i = indexArr2 - 1; i >= 0; i--) {
            result[indexArr1++] = arr2[i];
        }

        return result;
}}