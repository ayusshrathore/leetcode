class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        if (n > 12) return res;

        int parts = 0;
        String curr = "";
        f(s, 0, parts, n, curr, res);
        return res;
    }

    private static void f(String s, int idx, int parts, int n, String curr, List<String> res) {
        if (idx == n && parts == 4) {
            res.add(curr.substring(0, curr.length() - 1));
            return;
        }

        if (idx + 1 <= n)
            f(s, idx + 1, parts + 1, n, curr + s.substring(idx, idx + 1) + ".", res);

        if (idx + 2 <= n && isValid(s.substring(idx, idx + 2)))
            f(s, idx + 2, parts + 1, n, curr + s.substring(idx, idx + 2) + ".", res);

        if (idx + 3 <= n && isValid(s.substring(idx, idx + 3)))
            f(s, idx + 3, parts + 1, n, curr + s.substring(idx, idx + 3) + ".", res);

    }

    private static boolean isValid(String s) {
        if (s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val <= 255;
    }
}