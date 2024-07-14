class Solution {
    public int[][] merge(int[][] intervals) {
        // if (intervals == null || intervals.length == 0) {
        //     return new int[0][];
        // }

        // Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping interval, add currentInterval to the result and update currentInterval
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last interval
        mergedIntervals.add(currentInterval);

        // Convert the list to an array
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }
}