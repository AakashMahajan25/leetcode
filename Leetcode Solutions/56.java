import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort intervals by start time, then end time
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[][] answer = new int[intervals.length][2];
        int answerPointer = 0;

        answer[0][0] = intervals[0][0];
        answer[0][1] = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If overlapping, merge into current slot
            if (answer[answerPointer][1] >= intervals[i][0]) {
                answer[answerPointer][1] = Math.max(answer[answerPointer][1], intervals[i][1]);
            } else {
                // No overlap, move pointer and add new interval
                answerPointer++;
                answer[answerPointer][0] = intervals[i][0];
                answer[answerPointer][1] = intervals[i][1];
            }
        }

        return Arrays.copyOfRange(answer, 0, answerPointer + 1);
    }
}
