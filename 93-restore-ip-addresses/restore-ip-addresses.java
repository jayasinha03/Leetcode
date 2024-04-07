class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(result, s, "", 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String s, String current, int segmentStart, int segmentCount) {
        if (segmentCount == 4 && segmentStart == s.length()) {
            result.add(current);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (segmentStart + i > s.length()) {
                break;
            }
            String segment = s.substring(segmentStart, segmentStart + i);
            if ((segment.startsWith("0") && segment.length() > 1) || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            String newSegment = segmentCount == 0 ? segment : current + "." + segment;
            backtrack(result, s, newSegment, segmentStart + i, segmentCount + 1);
        }
    }
}