class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            int sumOfDigits = calculateSum(num);
            if(map.containsKey(sumOfDigits)){
                int prevOne = map.get(sumOfDigits);
                ans = Math.max(ans, prevOne + num);
                map.put(sumOfDigits, Math.max(prevOne, num));
            }else{
                map.put(sumOfDigits, num);
            }
        }
        return ans;
    }

    public int calculateSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;

    }
}