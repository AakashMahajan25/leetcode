import java.util.Arrays;

class Solution {
    public int hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1L) / k; 
        }
        return hours > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt(); 
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int needed = hoursNeeded(piles, mid);

            if (needed <= h) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
