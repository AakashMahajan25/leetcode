import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Optimal Approach
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            int middle = left + 1;
            int right = nums.length - 1;

            while (middle < right) {
                int sum = nums[left] + nums[middle] + nums[right];

                if (sum == 0) {
                    answer.add(Arrays.asList(nums[left], nums[middle], nums[right]));

                    while (middle < right && nums[middle] == nums[middle + 1]) middle++;
                    while (middle < right && nums[right] == nums[right - 1]) right--;

                    middle++;
                    right--;
                } else if (sum < 0) {
                    middle++;
                } else {
                    right--;
                }
            }
        }

        return answer;




        // List<List<Integer>> answer = new ArrayList<>();
        // Set<String> seen = new HashSet<>();
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int a = nums[i];
        //         int b = nums[j];
        //         int c = -(a + b);

        //         int count = map.getOrDefault(c, 0);
        //         if (c == a) count--;
        //         if (c == b) count--;

        //         if (count > 0) {
        //             List<Integer> triplet = Arrays.asList(a, b, c);
        //             Collections.sort(triplet);
        //             String key = triplet.get(0) + "," + triplet.get(1) + "," + triplet.get(2);

        //             if (!seen.contains(key)) {
        //                 seen.add(key);
        //                 answer.add(triplet);
        //             }
        //         }
        //     }
        // }

        // return answer;
    }
}
