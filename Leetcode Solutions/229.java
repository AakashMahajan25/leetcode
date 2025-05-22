import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // TC->O(N) SC->O(1) Cant exist more than 2 majority elements
        // This approach only takes one iteration, below ones take 2
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int threshold = nums.length/3 + 1;
        for (int i=0; i<nums.length; i++) {
            int element  = nums[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
            if (map.get(element) == threshold) {
                answer.add(element);
            }
        }
        return answer;



        // TC->O(2N) SC->O(N) 
        // HashMap<Integer, Integer> map = new HashMap<>();
        // List<Integer> uniqueElements = new ArrayList<>();
        // List<Integer> answer = new ArrayList<>();
        // int threshold = nums.length/3;
        // for (int i=0; i<nums.length; i++) {
        //     int element = nums[i];
        //     boolean exists = map.containsKey(element);
        //     if (!exists) {
        //         uniqueElements.add(element);
        //         map.put(element, 1);
        //     } else {
        //         map.put(element, map.get(element) +1);
        //     }
        // }
        // for (Integer key : map.keySet()) {
        //     if (map.get(key) > threshold) {
        //         answer.add(key);
        //     }
        // }
        // return answer;
    }
}