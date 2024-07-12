class Solution {
    public int minimumSum(int []nums) {
        int sz = nums.length;
        int minLeft[] = new int[sz];
        int minRight[] = new int[sz];
        for(int indx = 0; indx < sz; indx++){
            minLeft[indx] = Math.min((indx - 1 > -1) ? minLeft[indx-1] : Integer.MAX_VALUE, nums[indx]);
        }
        for(int indx = sz - 1; indx >= 0; indx--){
            minRight[indx] =  Math.min((indx + 1 < sz) ? minRight[indx + 1] : Integer.MAX_VALUE, nums[indx]);
        }
        int minSum = Integer.MAX_VALUE;
        for(int indx = 1; indx < sz-1; indx++){
            if(minLeft[indx-1] >= nums[indx] || minRight[indx+1] >= nums[indx])continue;
            int leftValue = minLeft[indx - 1];
            int rightValue = minRight[indx+1];
            minSum = Math.min(minSum, nums[indx] + rightValue + leftValue);
        }
        return minSum == Integer.MAX_VALUE ? - 1 : minSum;
    }
}