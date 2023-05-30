class MyHashSet {
    Map<Integer, Integer> mp;
    
    public MyHashSet() {
        mp = new HashMap<Integer, Integer>();
    }
    
    public void add(int key) {
        if(mp.containsKey(key))
            return;
        
        mp.put(key, 1);
    }
    
    public void remove(int key) {
        mp.remove(key);
    }
    
    public boolean contains(int key) {
        return mp.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */