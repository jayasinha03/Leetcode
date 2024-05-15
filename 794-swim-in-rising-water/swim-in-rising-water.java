class Solution {
    private boolean canReach(int i, int j, int[][] grid, int t, boolean[][] isVisited) {
        if(i < 0 || j < 0 || i >= grid[0].length || j >= grid[0].length || isVisited[i][j] || grid[i][j] > t) {
            return false;
        }
        isVisited[i][j] = true;
        if(i == grid[0].length-1 && j == grid[0].length - 1) return true;
        if(canReach(i+1, j, grid, t, isVisited)) return true;
        if(canReach(i, j+1, grid, t, isVisited)) return true;
        if(canReach(i-1, j, grid, t, isVisited)) return true;
        if(canReach(i, j-1, grid, t, isVisited)) return true;
        return false;
    }
    public int swimInWater(int[][] grid) {
        int t = grid[0].length * grid[0].length;
        for(int i = 0 ; i < t ; i++) {
            boolean[][] isVisited = new boolean[grid[0].length][grid[0].length];
            if(canReach(0, 0, grid, i, isVisited)) return i;
        }
        return 0;
    }
}