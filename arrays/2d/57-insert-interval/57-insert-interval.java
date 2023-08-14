class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int i = 0, n = intervals.length;
        
        while(i < n) {
            if (intervals[i][0] > newInterval[1]) break;
            else if (intervals[i][1] < newInterval[0])
                temp.add(intervals[i]);
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }

        temp.add(newInterval);
        while (i < n) temp.add(intervals[i++]);

        int[][] res = new int[temp.size()][2];
        for (i = 0; i < temp.size(); i++) res[i] = temp.get(i);

        return res;
    }
}