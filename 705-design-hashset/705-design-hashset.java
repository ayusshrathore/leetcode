class MyHashSet {
    private int[] arr;
    private int size = 10000000;
    
    public MyHashSet() {
        arr = new int[size];
        Arrays.fill(arr, -1);
    }
    
    public void add(int key) {
        int index = hash(key);
        
        if(arr[index] == -1)
            arr[index] = key;
    }
    
    public void remove(int key) {   
        int index = hash(key);
        
        arr[index] = -1;
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        
        return arr[index] != -1;
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