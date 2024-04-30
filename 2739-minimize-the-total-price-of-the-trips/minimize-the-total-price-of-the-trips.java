class Solution {

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {

        // Create Adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // For all the trips, find the shortest path and update the contribution map.
        Map<Integer, Integer> contributionMap = new HashMap<>();
        for (int[] t : trips) {
            bfs(n, adjList, contributionMap, t[0], t[1]);
        }

        // Calculate the minimum price using dfs with DP.
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = dfs(contributionMap, adjList, price, 0, dp, 0, -1);
        return ans;

    }

    private int dfs(Map<Integer, Integer> contributionMap, Map<Integer, List<Integer>> adjList, int[] price, int curr, int[][] dp, int isParentHalved, int parent) {
        if (dp[curr][isParentHalved] != -1) return dp[curr][isParentHalved];

        // For the current node, store the price with the price[current] halved.
        int halved = contributionMap.getOrDefault(curr, 0) * (price[curr] / 2);

        // For the current node, store the price with the price[current] not halved.
        int notHalved = contributionMap.getOrDefault(curr, 0) * price[curr];

        // if parent is halved, then current will be not halved
        // if parent is not halved, we can either half or not half it
        for (int neighbour : adjList.get(curr)) {
            if (neighbour != parent) {
                notHalved += dfs(contributionMap, adjList, price, neighbour, dp, 0, curr);
            }
        }
        if (isParentHalved == 1) {
            return dp[curr][isParentHalved] = notHalved;  // return the notHalved value since parent is halved and current can't be halved
        }

        for (int neighbour : adjList.get(curr)) {
            if (neighbour != parent) {
                halved += dfs(contributionMap, adjList, price, neighbour, dp, 1, curr);
            }
        }
        return dp[curr][isParentHalved] = Math.min(halved, notHalved);  // return the min of halved and non-halved when parent is not halved.
    }

    private void bfs(int n, Map<Integer, List<Integer>> adjList, Map<Integer, Integer> contibutionMap, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            if (temp == end) break;

            for (int neighbour : adjList.get(temp)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                    parent[neighbour] = temp;
                }
            }
        }
        start = end;
        while (start != -1) {
            contibutionMap.put(start, contibutionMap.getOrDefault(start, 0) + 1);
            start = parent[start];
        }
    }
}