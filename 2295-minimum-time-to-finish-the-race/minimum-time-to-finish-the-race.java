class Solution {
    
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        
        int n = tires.length; 
        if(numLaps==0) return 0; 
        int min[] = new int[numLaps+1]; 

        Arrays.fill(min, Integer.MAX_VALUE); 

        for(int i=0;i<n;i++){
            int base = tires[i][0];
            int curr = tires[i][0];
            int factor = tires[i][1];
            int lap = 1; 
            int sum = curr; 
            while(curr<changeTime + base && lap<=numLaps)
                {
                min[lap] = Math.min(min[lap], sum);
                curr = curr*factor;
                sum+=curr;
                lap++;
                }
        }
        //System.out.println(Arrays.toString(min));
        for(int lap = 1; lap<=numLaps;lap++){
            int curr = min[lap]; 

            for(int j=lap-1;j>=1;j--){
                curr = Math.min(curr, min[j] + min[lap-j] + changeTime); 
            }
            min[lap] = Math.min(min[lap], curr);
        }
        //System.out.println(Arrays.toString(min));
        return min[numLaps];
    }
}