class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        
        for(int i = 0; i < n / 2; i++) {
            swap(s, i, n-i-1);
        }
        
    }
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}