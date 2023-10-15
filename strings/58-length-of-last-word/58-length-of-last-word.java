class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        if(s==null|| s.length()==0) return 0;
        int i = s.length()-1;
        while(i>=0 && s.charAt(i)==' ')
        {
            i--; // we are skiping the end(tail) spaces

        }
        while(i>=0 && s.charAt(i)!=' ')
        {
            count++;
            i--;
        }
        return count;
    }
}