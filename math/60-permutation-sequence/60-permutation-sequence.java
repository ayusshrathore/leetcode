class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k--;
        String ans = "";
        while (true) {
            ans += numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) break;
            k %= fact;
            fact /= numbers.size();
        }
        return ans;
    }
}