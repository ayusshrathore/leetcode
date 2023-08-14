class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        
        List<Boolean> result = new ArrayList<>(Collections.nCopies(candies.length, false));
        
        for(int i = 0; i < candies.length; i++)
            maxCandies = Math.max(maxCandies, candies[i]);
        
        for(int i = 0; i < candies.length; i++)
            if(candies[i] + extraCandies >= maxCandies)
                result.set(i, true);
                
        return result;
    }
}