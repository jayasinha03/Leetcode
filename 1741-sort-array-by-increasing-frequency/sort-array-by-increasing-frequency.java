class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Calculate the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Sort the array based on the frequency and then by value
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> {
                    int freqA = frequencyMap.get(a);
                    int freqB = frequencyMap.get(b);
                    if (freqA == freqB) {
                        return b - a; 
                    } else {
                        return freqA - freqB;
                    }
                })
                .mapToInt(i -> i)
                .toArray();
    }
}