class Solution {
    public int largestVariance(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] = 1;
        }

        int res = 0;

        for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {
                if (count[first - 'a'] == 0 || count[second - 'a'] == 0) {
                    continue;
                }

                int firstCount = 0;
                int secondCount = 0;
                boolean pastSecond = false;

                for (char ch : s.toCharArray()) {
                    if (first == ch) firstCount++;
                    if (second == ch) secondCount++;

                    if (secondCount > 0) {
                        res = Math.max(res, firstCount - secondCount);
                    } else {
                        if (pastSecond == true) {
                            res = Math.max(res, firstCount - 1);
                        }
                    }

                    if (secondCount > firstCount) {
                        firstCount = 0;
                        secondCount = 0;
                        pastSecond = true;
                    }
                }
            }
        }

        return res;
    }
}