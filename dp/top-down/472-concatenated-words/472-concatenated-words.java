class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        Set<String> set = new HashSet<>();
        for (String s : words) set.add(s);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (f(words[i], set)) res.add(words[i]);
        }

        return res;
    }

    private static boolean f(String word, Set<String> set) {
        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1, word.length());

            if ((set.contains(prefix) && set.contains(suffix)) || 
                set.contains(prefix) && f(suffix, set))
                    return true;
        }
        return false;
    }
}