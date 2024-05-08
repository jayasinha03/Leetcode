class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the array in non-decreasing order
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // If the sum of weights is within limit, both can be carried
                left++;
                right--;
            } else {
                // If the sum exceeds limit, only one person can be carried
                right--;
            }
            boats++; // Increment boat count after each iteration
        }
        
        return boats;
    }
}