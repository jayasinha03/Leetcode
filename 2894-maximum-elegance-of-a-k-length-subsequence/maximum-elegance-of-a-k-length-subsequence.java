class Solution {
    long sqr(long x) {
        return x * x;
    }

    public long findMaximumElegance(int[][] items, int k) {
        final int n = items.length;
        Integer[] ind = new Integer[n];
        for (int i = 0; i < n; ++i) {
            ind[i] = i;
        }
        Arrays.sort(ind, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(items[y][0], items[x][0]);
            }
        });
        Map<Integer, Integer> num = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return Integer.compare(p2.getKey(), p1.getKey());
            }
        });
        long v = 0;
        for (int i = 0; i < k; ++i) {
            v += items[ind[i]][0];
            num.put(items[ind[i]][1], num.getOrDefault(items[ind[i]][1], 0) + 1);
            q.add(new Pair<>(-items[ind[i]][0], ind[i]));
        }
        long r = v + sqr(num.size());
        for (int i = k; i < n && !q.isEmpty(); ++i) {
            if (num.containsKey(items[ind[i]][1])) {
                continue;
            }
            int x = q.peek().getValue();
            q.poll();
            if (num.get(items[x][1]) == 1) {
                --i;
                continue;
            }
            v += items[ind[i]][0] - items[x][0];
            num.put(items[x][1], num.get(items[x][1]) - 1);
            num.put(items[ind[i]][1], num.getOrDefault(items[ind[i]][1], 0) + 1);
            r = Math.max(r, v + sqr(num.size()));
        }
        return r;
    }
}