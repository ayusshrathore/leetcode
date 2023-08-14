class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for(int amount : salary) {
            max = Math.max(max, amount);
            min  = Math.min(min, amount);
            
            sum += amount;
        }
        
        sum -= (max + min);
        
        return (double) sum / (n-2);
    }
}