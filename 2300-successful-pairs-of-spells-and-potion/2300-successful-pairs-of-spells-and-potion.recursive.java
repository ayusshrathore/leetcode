class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int low = 0, high = potions.length-1, n = spells.length, pointer = 0;
        int[] pairs = new int[n];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < n; i++) {
            int res = binarySearch(low, high, spells[i], potions, success);
            pairs[pointer++] = res < 0 ? 0 : potions.length-res;
        }
        
        return pairs;
    }
    public int binarySearch(int low, int high, int spell, int[] potions, long success) {
        if(low > high) return low;
        
        int mid = (low + high) >>> 1;
        
        if((long)potions[mid] * spell < success) // if we found success than it's is actually the idx, otherwise next larger element
            return binarySearch(mid+1, high, spell, potions, success);
        
        return binarySearch(low, mid-1, spell, potions, success);
    }
}
