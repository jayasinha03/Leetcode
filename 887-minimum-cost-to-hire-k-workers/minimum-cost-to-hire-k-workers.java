class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workerRatio = new double[n][2];

        for (int i = 0; i < n; i++) {
            workerRatio[i][0] = (double) wage[i] / quality[i];
            workerRatio[i][1] = quality[i];
        }

        Arrays.sort(workerRatio, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            double ratio = workerRatio[i][0];
            qualitySum += workerRatio[i][1];
            maxHeap.offer(workerRatio[i][1]);

            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, ratio * qualitySum);
            }
        }

        return minCost;
    }
}