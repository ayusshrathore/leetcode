class Solution {
    public int addDigits(int num) {
        if(num <= 9) return num;
        
        int ans = num;
        
        while(ans > 9)
            ans = add(ans);
        
        return ans;
    }
    public int add(int num){
        return num == 0 ? 0 : num % 10 + add(num / 10);
    }
}