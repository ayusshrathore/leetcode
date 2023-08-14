class MyHashSet {
    private Map<Integer, Integer> mp; // {hashedIndex (key), given key (value)}
    private int size = 100_000_000;
    
    public MyHashSet() {
        mp = new HashMap<Integer, Integer>();
    }
    
    public void add(int key) {
        int index = hash(key);
        
        if(!mp.containsKey(index))
            mp.put(index, key);
    }
    
    public void remove(int key) {   
        int index = hash(key);
        
        if(mp.containsKey(index))
            mp.remove(index);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        
        return mp.containsKey(index);
    }
    
    private int hash(int key) {
        return key % size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */