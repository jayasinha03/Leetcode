class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        Collections.sort(list, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA == freqB) {
                return b - a;
            } else {
                return freqA - freqB; 
            }
        });
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        
        return nums;
    }
}