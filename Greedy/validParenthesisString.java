class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                minOpen += 1;
                maxOpen += 1;
            } else if (i == ')') {
                minOpen -= 1;
                maxOpen -= 1;
            } else {
                minOpen -= 1;

                maxOpen += 1;
            }
            if (minOpen < 0) {
                minOpen = 0;
            }
            if (maxOpen < 0)
                return false;
        }
        return minOpen == 0;
    }
}