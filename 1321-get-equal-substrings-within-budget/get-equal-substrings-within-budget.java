class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
       int n = s.length();
        int[] costs = new int[n];

        // Calculate the costs for each character change
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int currentCost = 0;
        int maxLength = 0;

        // Use sliding window approach
        for (int right = 0; right < n; right++) {
            currentCost += costs[right];

            // If currentCost exceeds maxCost, shrink the window from the left
            while (currentCost > maxCost) {
                currentCost -= costs[left];
                left++;
            }

            // Update the maximum length of the valid substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength; 
    }
}