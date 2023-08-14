class Solution { // DP, BOTTOM-UP
    public int bestTeamScore(int[] scores, int[] ages) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < ages.length; i++)
            list.add(new Pair(ages[i], scores[i]));

        Collections.sort(list, (p1, p2) -> {
            return p1.age == p2.age ? p1.score - p2.score : p1.age - p2.age;
        });
        
        int[] dp = new int[list.size()];
        dp[0] = list.get(0).score;
        int max = dp[0];
        for (int i = 0; i < ages.length; i++) {
            dp[i] = list.get(i).score;
            for (int j = 0; j < i; j++) {
                if (list.get(j).score <= list.get(i).score)
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).score);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    class Pair {
        int age, score;
        public Pair(int _age, int _score) {
            this.age = _age;
            this.score = _score;
        }
    }
}