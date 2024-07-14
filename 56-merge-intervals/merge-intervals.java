class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        // Initialize the first interval
        mergedIntervals.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // Get the last added interval in the merged list
            int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int[] currentInterval = intervals[i];

            // Check if intervals overlap
            if (lastInterval[1] >= currentInterval[0]) {
                // Merge the intervals
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // Add the current interval
                mergedIntervals.add(currentInterval);
            }
        }

        // Convert the list to an array
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }

        return result;
    }
}
