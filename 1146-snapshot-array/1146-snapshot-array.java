class SnapshotArray { // Design
    private int snapId;
    private List<List<Pair<Integer,Integer>>> list;

    public SnapshotArray(int length) {
        this.snapId = 0;
        this.list = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            List<Pair<Integer,Integer>> tmp = new ArrayList<>(); 
            tmp.add(new Pair(0,0)); // {snapId, val}
            list.add(i, tmp);
        }
    }

    public void set(int index, int val) {
        list.get(index).add(new Pair<>(snapId, val));
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        int start = 0;
        int end = list.get(index).size() - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (list.get(index).get(mid).getKey() <= snap_id) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.get(index).get(end).getValue();
    }
}
