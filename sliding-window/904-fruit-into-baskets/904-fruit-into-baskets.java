class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[j], map.get(fruits[j]) - 1); // decrement fruit count
                map.remove(fruits[j], 0); // remove fruit from map if count of fruit is 0
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}