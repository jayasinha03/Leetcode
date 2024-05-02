class Solution {
    public boolean checkString(String s) {
        boolean foundB = false;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                foundB = true;
            } else { // c == 'a'
                if (foundB) {
                    return false;
                }
            }
        }

        return true;
    }
}