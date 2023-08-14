class Solution {
    public String predictPartyVictory(String senate) {
        
        int rCount = 0, dCount = 0, rBan = 0, dBan = 0; // Initialyy number of Senators for each party
       
        Queue<Character> q = new LinkedList<>();
        
        for (int i = 0; i < senate.length(); i++) {
            char ch = senate.charAt(i);
            
            q.add(ch);
            
            if (ch == 'R') rCount++;
            else dCount++;
        }
        
        while (rCount > 0 && dCount > 0) { // While any party has eligible Senators

            char curr = q.poll(); // Pop the senator with turn

            // if eligible, make a the ban on the other party, enqueue again.
            // if not, decrement the ban and count of the party.
            if (curr == 'D') {
                if (dBan > 0) {
                    dBan--;
                    dCount--;
                } else {
                    rBan++;
                    q.add('D');
                }
            } else {
                if (rBan > 0) {
                    rBan--;
                    rCount--;
                } else {
                    dBan++;
                    q.add('R');
                }
            }
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}