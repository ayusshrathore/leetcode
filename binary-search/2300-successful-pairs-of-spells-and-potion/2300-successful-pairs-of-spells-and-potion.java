class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, pointer = 0;
        int[] pairs = new int[n];
        
        Arrays.sort(potions);
        
        for(int i = 0; i < n; i++) {
            int res = binarySearch(spells[i], potions, success);
            pairs[pointer++] = res < 0 ? 0 : potions.length-res;
        }
        
        return pairs;
    }
    public int binarySearch(int spell, int[] potions, long success) {
        int low = 0, high = potions.length-1;
        
        while(low <= high) {
            int mid = (low + high) >>> 1;
            
            if((long) potions[mid] * spell < success) // if we found success than it's is actually the idx, otherwise next larger element
                low = mid + 1;
            
            else high = mid - 1;
        }
        
        return low;
    }
}
