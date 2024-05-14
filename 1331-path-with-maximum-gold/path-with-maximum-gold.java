class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) { // Found a cell with gold
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0; // Base case: out of bounds or no gold in this cell
        }

        int currentGold = grid[i][j];
        grid[i][j] = 0; // Marking the cell as visited

        // Explore all four directions
        int maxGold = currentGold + Math.max(
                Math.max(dfs(grid, i + 1, j), dfs(grid, i - 1, j)),
                Math.max(dfs(grid, i, j + 1), dfs(grid, i, j - 1))
        );

        grid[i][j] = currentGold; // Reverting the cell back to its original state

        return maxGold;
    }
}