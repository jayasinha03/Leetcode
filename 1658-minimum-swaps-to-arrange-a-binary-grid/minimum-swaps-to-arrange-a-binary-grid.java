class Solution {
    public int minSwaps(int[][] grid) {
        int len = grid.length, moves = 0;
        // count each rows the numbers of zeros, we get a array A
        int[] arr = new int[len];
        // creat a map of zero count to index
        for (int i = 0; i < len; i++)
            for (int j = len - 1; j >= 0; j--)
                if (grid[i][j] == 0)
                    arr[i]++;
                else
                    break;
        //System.out.println(Arrays.toString(arr));
        // verify is it solveable
        for (int i = 1; i < len; i++) {
            int cnt = 0;
            for (int val : arr)
                if (val >= i)
                    cnt++;
            if (cnt < len - i)
                return -1;
        }
        // swaps top n-1 elements
        for (int i = 0; i < len - 1; i++) {
            int need = len - 1 - i;
            if (need > arr[i]) {
                //System.out.printf("before: i-%d, need-%d, moves %d - %s\n", i, need, moves, Arrays.toString(arr));
                // not in place, find the first one meet the cnt and swap it up
                for (int j = i + 1; j < len; j++) {
                    if (arr[j] >= need) {
                        swap(i, j, arr);
                        moves += j - i;
                        break;
                    }

                }
                //System.out.printf("after: i-%d, need-%d, moves %d - %s\n", i, need, moves, Arrays.toString(arr));
            }
        }
        return moves;
    }

    void swap(int to, int from, int[] arr) {
        for (int i = from; i > to; i--) {
            int tmp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }
}