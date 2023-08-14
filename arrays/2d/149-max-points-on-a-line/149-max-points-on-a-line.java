class Solution {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int[] point_1 : points) {
            Map<Double, Integer> map= new HashMap<>();
            for (int[] point_2 : points) {
                if (point_1 == point_2) 
                    continue;
                double slope = 0;
                if (point_2[0] == point_1[0]) 
                    slope = Double.POSITIVE_INFINITY; 
                else 
                    slope = (point_2[1] - point_1[1]) / 
                            (double)(point_2[0] - point_1[0]);
                map.put(slope, map.getOrDefault(slope, 0) + 1 );
                if (map.get(slope) > res) 
                    res = map.get(slope);
            }
        }
        return res + 1;
    }
}