class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n+1]; /* Probablity of getting score = i */
        
        P[0] = 1; /* Initially score = 0 */
        double currProbSum = k == 0 ? 0 : 1; /* if k == 0 prob sum will always be equal to 0 */
        
        for(int i = 1; i <= n; i++) {
                /* Prob of score card = 1 / maxPts
                   Remaining score = P[i - card] */
                P[i] = currProbSum / maxPts;
                
                if(i < k)
                    currProbSum += P[i]; // so that we can use this sum for next card
                
                if(i-maxPts >= 0 && i-maxPts < k) 
                    currProbSum -= P[i - maxPts]; // subtracting the last term
        }
        
        // Adding prob from k -> n
        double sum = 0;
        for(int i = k; i <= n; i++)
            sum += P[i];
        
        return sum;
    }
}