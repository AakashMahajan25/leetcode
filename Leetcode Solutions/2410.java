import java.util.Arrays;
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // Brute Force Approach TC->O(mlogm + nlogn) SC->O(1)
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = players.length-1;
        int j = trainers.length-1;
        int matches = 0;
        while (i>=0 && j>=0) {
            if (trainers[j]>=players[i]) {
                matches++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return matches;
    }
}