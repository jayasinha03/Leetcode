class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int maxK = -1;
        
        for (int num : nums) {
            numSet.add(num);
        }
        
        for (int num : nums) {
            if (numSet.contains(-num)) {
                maxK = Math.max(maxK, num);
            }
        }
        
        return maxK != -1 ? maxK : -1;
    }
}