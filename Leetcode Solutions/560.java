class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            int remove = prefixSum - k;
            answer += map.getOrDefault(remove, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }
}