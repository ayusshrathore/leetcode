class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            arr[i] = new int[2];
            arr[i][0] = nums1[i]; /* nums1 */
            arr[i][1] = nums2[i]; /* nums2 */
        }
        
        Arrays.sort(arr, (a, b) -> b[1] - a[1]); /* sorting nums2 in desc */
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
            
        long sum = 0;
        for(int i = 0; i < k; i++) { /* calculating min till kth index */
            sum += arr[i][0];
            pq.add(arr[i][0]);
        }
        
        long result = sum * arr[k-1][1]; /* till kth index */
        
        for(int i = k; i < n; i++) { /* calc min for the rest of the elements*/
            sum += arr[i][0] - pq.peek();
            pq.poll();
            pq.add(arr[i][0]);
            
            result = Math.max(result, sum*arr[i][1]);
        }
        
        return result;
    }
}