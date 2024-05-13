class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordFrequencies = new int[words.length];
        int[] queryFrequencies = new int[queries.length];

        // Calculate frequencies of lexicographically smallest character for each word
        for (int i = 0; i < words.length; i++) {
            wordFrequencies[i] = calculateFrequency(words[i]);
        }

        // Calculate frequencies of lexicographically smallest character for each query
        for (int i = 0; i < queries.length; i++) {
            queryFrequencies[i] = calculateFrequency(queries[i]);
        }

        // Count the number of words in words such that f(queries[i]) < f(W) for each W in words
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < wordFrequencies.length; j++) {
                if (queryFrequencies[i] < wordFrequencies[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    private int calculateFrequency(String word) {
        char smallestChar = 'z'; // Start with the largest character
        int frequency = 0;
        for (char c : word.toCharArray()) {
            if (c < smallestChar) {
                smallestChar = c;
                frequency = 1;
            } else if (c == smallestChar) {
                frequency++;
            }
        }
        return frequency;
    }
}