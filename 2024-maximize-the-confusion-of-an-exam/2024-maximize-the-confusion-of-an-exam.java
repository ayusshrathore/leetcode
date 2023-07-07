class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // case-1: F -> T
        int n = answerKey.length();
        int res = 0;
        int i = 0, j = 0;
        int countF = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'F') {
                countF++;
            }
            while (countF > k) {
                if (answerKey.charAt(i) == 'F') {
                    countF--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        // case-2: T -> F
        i = 0;
        j = 0;
        int countT = 0;
        while (j < n) {
            if (answerKey.charAt(j) == 'T') {
                countT++;
            }
            while (countT > k) {
                if (answerKey.charAt(i) == 'T') {
                    countT--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}